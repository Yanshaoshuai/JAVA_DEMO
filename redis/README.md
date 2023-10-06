#### 基本类型
##### string

动态字符串
- 可以修改,内部是自定义结构
- 支持扩容,预分配空间，小于1m时2倍扩容，大于1m时每次扩容1m，最多512m
- 操作
```shell
> set name yan
"OK"

> get name
"yan"

> exists name
(integer) 1

> del name
(integer) 1

> get name
(nil)
>
## 设置超时时间
> set name yan
"OK"

> expire name 5
(integer) 1

> get name
"yan"
##5秒后
> get name
(nil)
##set时设置过期时间
> setex name 5 yan
"OK"

> get name
"yan"

> get name
(nil)

##不存在才设置
> setnx name yan
(integer) 1

> get name
"yan"

> setnx name wang
(integer) 0

> get name
"yan"

##值为整数时可以进行自增操作
> set age 25
"OK"

> get age
"25"

> incr age
(integer) 26

> incrby age 1
(integer) 27

> incrby age -2
(integer) 25

```

##### list
双向列表

- 结构: 元素较少时内部结构为内存连续的ziplist,元素多时改成quicklist(使用双向指针串联ziplist)

- 复杂度: 插入O(1) 索引O(n)

- 操作
```shell
##右进左出-->队列
> rpush queue python java go
(integer) 3

> lpop queue
"python"

> lpop queue
"java"

> lpop queue
"go"

##右进右出 -->栈
> rpush stack python java go
(integer) 3

> rpop stack
"go"

> rpop stack
"java"

> rpop stack
"python"

## 慢操作 
> rpush books python java go
(integer) 3
# 正数代表索引从0开始
> lindex books 1
"java"
# 负数代表从末尾开始的第几个元素
> lindex books -1
"go"
#列出从索引第一个到最后一个的元素 O(n)
> lrange books 0 -1
1) "python"
2) "java"
3) "go"
#只保留从索引1到最后一个元素区间中的元素
> ltrim books 1 -1
"OK"

> lrange books 0 -1
1) "java"
2) "go"
#清除列表
> ltrim books 1 0
"OK"

> llen books
(integer) 0
```


##### hash

- 结构:数组+链表

- 操作
```shell
> hset books java "think in java"
(integer) 1

> hset books golang "concurrency in go"
(integer) 1

> hset books python "python cookbook"
(integer) 1

> hgetall books
1) "java"
2) "think in java"
3) "golang"
4) "concurrency in go"
5) "python"
6) "python cookbook"

> hlen books
(integer) 3

> hget books java
"think in java"

> hset books golang "learning go programming"
(integer) 0

> hget books golang
"learning go programming"
#批量设置
> hmset books java "effective java" python "learning python" golang "modern golang programming"
"OK"

> hgetall books
1) "java"
2) "effective java"
3) "golang"
4) "modern golang programming"
5) "python"
6) "learning python"

# 增加数值键
> hset user-yan age 28
(integer) 1

> hincrby user-yan age 2
(integer) 30
```

##### set

- 结构:相当于所有value值为NULL的字典

- 操作
```shell
> sadd books python
(integer) 1

> sadd books python
(integer) 0

> sadd books java golang
(integer) 2

> smembers books
1) "golang"
2) "java"
3) "python"
#是否存在元素
> sismember books java
(integer) 1

> sismember books rust
(integer) 0
#获取长度
> scard books
(integer) 3
#弹出一个元素
> spop books
"python"
```

##### zset

- 结构:跳跃列表

- 操作
```shell
> zadd books 9.0 "think in java"
(integer) 1

> zadd books 8.9 "java concurrency"
(integer) 1

> zadd books 8.6 "java cookbook"
(integer) 1
# 按照score顺序获取排序区间(从0开始)中的值
> zrange books 0 -1
1) "java cookbook"
2) "java concurrency"
3) "think in java"
#按照score顺序逆序获取排序区间中的值
> zrevrange books 0 -1
1) "think in java"
2) "java concurrency"
3) "java cookbook"
#获取长度
> zcard books
(integer) 3
#获取score score内部使用double存储 会损失精度
> zscore books "java concurrency"
"8.9000000000000004"
#获取排名
> zrank books "java concurrency"
(integer) 1
#通过score区间获取元素和排名 并返回score
> zrangebyscore books -inf 8.91 withscores
1) "java cookbook"
2) "8.5999999999999996"
3) "java concurrency"
4) "8.9000000000000004"
#删除元素
> zrem books "java concurrency"
(integer) 1

> zrange books 0 -1
1) "java cookbook"
2) "think in java"
```

#### 实用功能

##### HyperLogLog

- 功能: 去重计数
- 结构: 稀疏存储和密集存储
- 指令: pfadd pfcount pfmerge
- 使用
```shell
> pfadd books "java"
(integer) 1

> pfadd books "golang"
(integer) 1

> pfadd books "python"
(integer) 1

> pfcount books
(integer) 3

> pfadd books "java" "python"
(integer) 0

> pfcount books
(integer) 3
```
##### Bloom Filter

- 功能: 判断值是否存在

- 指令: bf.add bf.exists bf.madd bf.mexists bf.reserve

- 使用 todo

##### scan

- 功能:扫描key
- 用法: scan cursor(开始槽位) match pattern(正则) count N(扫描槽位数)
```shell
> mset user-01 1 user-02 2 user-03 3 user-04 4 user-05 5
"OK"

> scan 0 match user-* count 2
1) "1"
2) 1) "user-05"
   2) "user-02"

> scan 1 match user-* count 2
1) "0"
2) 1) "user-03"
   2) "user-01"
   3) "user-04"

> scan 0 match user-* count 2
1) "1"
2) 1) "user-05"
   2) "user-02"
```




#### 部署模式

##### 集群模式

##### 哨兵模式

##### Cluster模式