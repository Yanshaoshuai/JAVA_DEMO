# keytool 命令

> - [Name](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#name)
> - [Synopsis](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#synopsis)
> - [Description](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#description)
> - [Command and Option Notes](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#command-and-option-notes)
> - [Commands and Options](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-and-options)
> - [Commands for Creating or Adding Data to the Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-creating-or-adding-data-to-the-keystore)
> - [Commands for Importing Contents from Another Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-importing-contents-from-another-keystore)
> - [Commands for Generating a Certificate Request](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-generating-a-certificate-request)
> - [Commands for Exporting Data](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-exporting-data)
> - [Commands for Displaying Data](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-data)
> - [Commands for Managing the Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-managing-the-keystore)
> - [Commands for Displaying Security-related Information](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-security-related-information)
> - [Commands for Displaying Program Version](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-program-version)
> - [Commands for Displaying Help Information](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#commands-for-displaying-help-information)
> - [Common Command Options](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#common-command-options)
> - [Pre-configured options file](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#pre-configured-options-file)
> - [Examples of Option Values](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#examples-of-option-values)
> - [Supported Named Extensions](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#supported-named-extensions)
> - [Examples of Tasks in Creating a keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#examples-of-tasks-in-creating-a-keystore)
> - [Generating the Key Pair](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#generating-the-key-pair)
> - [Requesting a Signed Certificate from a CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#requesting-a-signed-certificate-from-a-ca)
> - [Importing a Certificate for the CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-a-certificate-for-the-ca)
> - [Importing the Certificate Reply from the CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-the-certificate-reply-from-the-ca)
> - [Exporting a Certificate That Authenticates the Public Key](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#exporting-a-certificate-that-authenticates-the-public-key)
> - [Importing the Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-the-keystore)
> - [Generating Certificates for an SSL Server](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#generating-certificates-for-an-ssl-server)
> - [Terms](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#terms)
> - [Warnings](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#warnings)
> - [Importing Trusted Certificates Warning](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-trusted-certificates-warning)
> - [Passwords Warning](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#passwords-warning)
> - [Certificate Conformance Warning](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#certificate-conformance-warning)
> - [Import a New Trusted Certificate](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#import-a-new-trusted-certificate)
> - [Import a Certificate Reply](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#import-a-certificate-reply)

## 名字

keytool - 密钥和证书管理实用程序
## 概要
keytool [commands]

commands
keytool 的命令包括：

> - `-certreq`: 生成证书请求
> - `-changealias`: 更改条目的别名
> - `-delete`: 删除条目
> - `-exportcert`: 导出证书
> - `-genkeypair`: 生成密钥对
> - `-genseckey`: 生成密钥
> - `-gencert`: 从证书请求生成证书
> - `-importcert`:导入证书或证书链
> - `-importpass`: 导入密码
> - `-importkeystore`: 从另一个keystore(密钥库)导入一个或所有条目
> - `-keypasswd`: 更改条目的密钥密码
> - `-list`: 列出keystore(密钥库)中的条目
> - `-printcert`: 打印证书的内容
> - `-printcertreq`: 打印证书请求的内容
> - `-printcrl`: 打印证书吊销列表 (CRL) 文件的内容
> - `-storepasswd`: 更改keystore(密钥库)的存储密码
> - `-showinfo`: 显示安全相关信息
> - `-version`: 打印程序版本

有关这些命令及其选项的说明，请参阅命令和选项。

## 描述

keytool 命令是一个密钥和证书管理实用程序。它使用户能够通过使用数字签名管理自己的公钥/私钥对和相关证书，以用于自我认证（用户向其他用户和服务认证自己）或数据完整性和认证服务。 keytool 命令还使用户能够缓存其通信对等方的公钥（以证书的形式）。

证书是来自一个实体（个人、公司等）的数字签名声明，它表明某个其他实体的公钥（和一些其他信息）具有特定的价值。当数据被数字签名时，可以验证签名以检查数据的完整性和真实性。完整性意味着数据没有被修改或篡改，真实性意味着数据来自声称创建并签署它的个人。

keytool 命令还使用户能够管理对称加密和解密（数据加密标准）中使用的密钥和密码。它还可以显示其他与安全相关的信息。

keytool 命令将密钥和证书存储在keystore(密钥库)中。

keytool 命令使用 jdk.certpath.disabledAlgorithms 和 jdk.security.legacyAlgorithms 安全属性来确定哪些算法被视为安全风险。当禁用或使用旧算法时，它会发出警告。 jdk.certpath.disabledAlgorithms 和 jdk.security.legacyAlgorithms 安全属性在 java.security 文件（位于 JDK 的 $JAVA_HOME/conf/security 目录中）中定义。

## 命令和选项说明

以下注释适用于命令和选项中的描述：

- 所有命令和选项名称前面都有一个连字符 (-)。

- 只能提供一个命令。

- 可以按任何顺序提供每个命令的选项。

- 选项有两种，一种是单值，只能提供一次。如果多次提供单值选项，则使用最后一个的值。另一种是多值类型，可以多次提供，所有值都被使用。当前支持的唯一多值选项是用于生成 X.509v3 证书扩展的 -ext 选项。

- 所有非斜体或大括号 ({ }) 或方括号 ([ ]) 中的项目都必须按原样显示。

- 选项周围的大括号表示在命令行上未指定选项时使用默认值。大括号也用于 -v、-rfc 和 -J 选项，它们仅在出现在命令行上时才有意义。它们没有任何默认值。

- 选项周围的括号表示当命令行上未指定选项时提示用户输入值。对于 -keypass 选项，如果您没有在命令行中指定该选项，那么 keytool 命令首先会尝试使用密钥库密码来恢复私钥/秘密密钥。如果此尝试失败，则 keytool 命令会提示您输入私钥/密钥密码。

- 斜体项目（选项值）表示必须提供的实际值。例如，这里是 -printcert 命令的格式：

  > keytool -printcert {-file *cert_file*} {-v}
  >
  > 指定 -printcert 命令时，将 cert_file 替换为实际文件名，如下所示： 
  >
  > keytool -printcert -file VScert.cer

- 选项值包含空白（空间）时，必须将选项值封闭在引号中。

## 命令和选项

keytool 命令及其选项可以按它们执行的任务进行分组。

用于创建或添加数据到密钥库的命令:

- `-gencert`
- `-genkeypair`
- `-genseckey`
- `-importcert`
- `-importpass`

从另一个密钥库导入内容的命令:

- `-importkeystore`

生成证书请求的命令:

- `-certreq`

导出数据的命令:

- `-exportcert`

显示数据的命令:

- `-list`
- `-printcert`
- `-printcertreq`
- `-printcrl`

管理密钥库的命令:

- `-storepasswd`
- `-keypasswd`
- `-delete`
- `-changealias`

显示安全相关信息的命令:

- `-showinfo`

显示程序版本的命令:

- `-version`

## 用于创建或添加数据到密钥库的命令

`-gencert`

以下是 `-gencert` 命令的可用选项:

- {`-rfc`}: 以 RFC（请求评论）样式输出

- {`-infile` *infile*}: 输入文件名

- {`-outfile` *outfile*}: 输出文件名

- {`-alias` *alias*}: 要处理的条目的别名

- {`-sigalg` *sigalg*}: 签名算法名称

- {`-dname` *dname*}:专有名称

- {`-startdate` *startdate*}: 证书有效期开始日期和时间

- {`-ext` *ext*}*: X.509 扩展

- {`-validity` *days*}: 有效天数

- [`-keypass` *arg ] : 密钥密码

- {`-keystore` *keystore*}: 密钥库名称

- [`-storepass` *arg*] : 密钥库密码

- {`-storetype` *type*}: 密钥库类型

- {`-providername` *name*}: 提供者名称

- {`-addprovider` *name* [`-providerarg` *arg*]}: 按名称添加安全提供程序（例如 SunPKCS11），并带有可选的配置参数。 安全提供者的值是在模块中定义的安全提供者的名称。

  例如，

  > `keytool -addprovider SunPKCS11 -providerarg some.cfg ...`

  **Note:**

  出于兼容性原因，即使现在在模块中定义了 SunPKCS11 提供程序，仍然可以使用 `-providerclass sun.security.pkcs11.SunPKCS11` 加载它。 这是 JDK 中唯一需要配置的模块，因此与 `-providerclass` 选项一起使用最广泛。 对于位于类路径上并通过反射加载的遗留安全提供程序，仍应使用 `-providerclass`。

- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。

  例如，如果 `MyProvider` 是通过反射加载的旧提供程序，

  > `keytool -providerclass com.example.MyProvider ...`

- {`-providerpath` *list*}: 提供者类路径

- {`-v`}: 详细输出

- {`-protected`}: 通过受保护机制提供的密码

使用 -gencert 命令生成证书作为对证书请求文件（可以通过 keytool -certreq 命令创建）的响应。该命令从 infile 读取请求，如果省略，则从标准输入读取请求，使用别名的私钥对其进行签名，并将 X.509 证书输出到 outfile 或如果省略，则输出到标准输出。指定 -rfc 时，输出格式为 Base64 编码的 PEM；否则，将创建一个二进制 DER。

-sigalg 值指定用于签署证书的算法。 startdate 参数是证书有效的开始时间和日期。 days 参数表示证书应被视为有效的天数。

提供 dname 时，将其用作生成证书的主题。否则，使用证书请求中的那个。

-ext 值显示将在证书中嵌入哪些 X.509 扩展。阅读通用命令选项以了解 -ext 的语法。

-gencert 选项使您能够创建证书链。以下示例创建一个证书 e1，该证书在其证书链中包含三个证书。

```
keytool -alias ca -dname CN=CA -genkeypair -keyalg rsa
keytool -alias ca1 -dname CN=CA -genkeypair -keyalg rsa
keytool -alias ca2 -dname CN=CA -genkeypair -keyalg rsa
keytool -alias e1 -dname CN=E1 -genkeypair -keyalg rsa
```

以下两个命令创建一个签名证书链； ca签ca1和ca1签ca2，都是自颁发的：

```
keytool -alias ca1 -certreq |
    keytool -alias ca -gencert -ext san=dns:ca1 |
    keytool -alias ca1 -importcert

keytool -alias ca2 -certreq |
    keytool -alias ca1 -gencert -ext san=dns:ca2 |
    keytool -alias ca2 -importcert
```

以下命令创建证书 e1 并将其存储在 e1.cert 文件中，该文件由 ca2 签名。 因此，e1 的证书链中应该包含 ca、ca1 和 ca2：

```
keytool -alias e1 -certreq | keytool -alias ca2 -gencert > e1.cert
```

```
-genkeypair
```

以下是 `-genkeypair` 命令的可用选项：

- {`-alias` *alias*}: 要处理的条目的别名
- `-keyalg` *alg*: 密钥算法名称
- {`-keysize` *size*}: 密钥位大小
- {`-groupname` *name*}: 组名。 例如，椭圆曲线名称。
- {`-sigalg` *alg*}: 签名算法名称
- {`-signer` *alias*}: 签名者别名
- [`-signerkeypass` *arg*] ： 签名者密钥密码
- [`-dname` *name*] ：专有名称
- {`-startdate` *date*}: 证书有效期开始日期和时间
- {`-ext` *value*}*: X.509 扩展
- {`-validity` *days*}: 有效天数
- [`-keypass` *arg*] :  密钥密码
- {`-keystore` *keystore*}: Keystore(密钥库)名称
- [`-storepass` *arg*] : Keystore(密钥库)密码
- {`-storetype` *type*}: Keystore(密钥库)类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*] }: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}: 通过受保护机制提供的密码

使用 -genkeypair 命令生成密钥对（公钥和关联的私钥）。如果未指定 -signer 选项，则公钥将包装在 X.509 v3 自签名证书中并存储为单元素证书链。当指定 -signer 选项时，将生成一个新证书并由指定的签名者签名并存储为多元素证书链（包含生成的证书本身，以及签名者的证书链）。证书链和私钥存储在由其别名标识的新密钥库条目中。

-keyalg 值指定用于生成密钥对的算法，-keysize 值指定要生成的每个密钥的大小。 -sigalg 值指定用于签署证书的算法。此算法必须与 -keyalg 值兼容。

-groupname 值指定要生成的密钥的命名组（例如，椭圆曲线的标准或预定义名称）。只能指定 -groupname 和 -keysize 之一。

-signer 值指定密钥库中已存在的签名者的 PrivateKeyEntry 的别名。此选项用于使用签名者的私钥对证书进行签名。这对于密钥协商算法（即 -keyalg 值为 XDH、X25519、X448 或 DH）特别有用，因为这些密钥不能用于数字签名，因此无法创建自签名证书。

-signerkeypass 值指定签名者私钥的密码。可以指定签名者条目的私钥是否由与存储密码不同的密码保护。

-dname 值指定要与 -alias 值关联的 X.500 可分辨名称。如果未指定 -signer 选项，则使用指定的专有名称填充自签名证书的颁发者和主题字段。如果指定了 -signer 选项，则证书的主题字段将填充指定的专有名称，而颁发者字段将填充签名者证书的主题字段。如果在命令行中未提供可分辨名称，则会提示用户输入一个。

-keypass 的值是用于保护生成的密钥对的私钥的密码。如果未提供密码，则会提示用户输入密码。如果您在提示符处按下 Return 键，则密钥密码将设置为与密钥库密码相同的密码。 -keypass 值必须至少包含六个字符。

-startdate 的值指定证书的颁发时间，也称为 X.509 证书的 Validity 字段的“Not Before”值。

选项值可以设置为以下两种形式之一：

([+-]nnn[ymdHMS])+

[yyyy/mm/dd] [HH:MM:SS]

对于第一种形式，发布时间从当前时间偏移指定的值。 该值是一系列子值的串联。 在每个子值内，加号 (+) 表示向前移动，减号 (-) 表示向后移动。 要移动的时间是 nnn 个单位，以年、月、日、小时、分钟或秒为单位（分别由单个字符 y、m、d、H、M 或 S 表示）。 发布时间的准确值是通过对每个子值使用 java.util.GregorianCalendar.add(int field, int amount) 方法从左到右计算的。 例如，可以通过以下方式指定发布时间：

```java
Calendar c = new GregorianCalendar();
c.add(Calendar.YEAR, -1);
c.add(Calendar.MONTH, 1);
c.add(Calendar.DATE, -1);
return c.getTime()
```

使用第二种形式，用户将确切的发布时间设置为两部分，年/月/日和时：分：秒（使用当地时区）。 用户只能提供一部分，这意味着另一部分与当前日期（或时间）相同。 用户必须提供格式定义中显示的确切位数（较短时用 0 填充）。 当同时提供日期和时间时，两个部分之间有一个（并且只有一个）空格字符。 小时应始终以 24 小时格式提供。

如果未提供该选项，则开始日期为当前时间。 该选项只能提供一次。

date 的值指定证书应被视为有效的天数（从 -startdate 指定的日期开始，或未指定 -startdate 时的当前日期开始）。

```
-genseckey
```

以下是 `-genseckey` 命令的可用选项：

- {`-alias` *alias*}: 要处理的条目的别名
- [`-keypass` *arg*] : 密钥密码
- `-keyalg` *alg*: 密钥算法名称
- {`-keysize` *size*}: 密钥位大小
- {`-keystore` *keystore*}:  Keystore(密钥库)名称
- [`-storepass` *arg*] : Keystore(密钥库)密码
- {`-storetype` *type*}: Keystore(密钥库)类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}: 通过受保护机制提供的密码

使用 `-genseckey` 命令生成密钥并将其存储在由 `alias` 标识的新 `KeyStore.SecretKeyEntry` 中。

`-keyalg` 的值指定用于生成密钥的算法，而 `-keysize` 的值指定生成的密钥的大小。 `-keypass` 值是保护密钥的密码。 如果未提供密码，则会提示用户输入密码。 如果您在提示符处按下 **Return** 键，则密钥密码将设置为用于 `-keystore` 的相同密码。 `-keypass` 值必须至少包含六个字符。

```
-importcert
```

以下是 `-importcert` 命令的可用选项：

- {`-noprompt`}: 不提示
- {`-trustcacerts`}: 来自 cacerts 的信任证书
- {`-protected`}: 密码是通过受保护的机制提供的
- {`-alias` *alias*}: 要处理的条目的别名
- {`-file` *file*}: 输入文件名
- [`-keypass` *arg*] : 密钥密码
- {`-keystore` *keystore*}: Keystore(密钥库)名称
- {`-cacerts`}: 访问 cacerts Keystore(密钥库)
- [`-storepass` *arg*] : Keystore(密钥库)密码
- {`-storetype` *type*}: Keystore(密钥库)类型
- {`-providername` *name*}:提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出

使用 -importcert 命令从 -file 文件读取证书或证书链（后者以 PKCS#7 格式的回复或 X.509 证书序列提供），并将其存储在由 - alias标识的密钥库条目。如果未指定 -file 文件，则从标准输入读取证书或证书链。

keytool 命令可以导入 X.509 v1、v2 和 v3 证书，以及由该类型证书组成的 PKCS#7 格式的证书链。要导入的数据必须以 Internet RFC 1421 标准定义的二进制编码格式或可打印编码格式（也称为 Base64 编码）提供。在后一种情况下，编码必须在开头以 -----BEGIN 开头的字符串为界，在结尾处以 -----END 开头的字符串为界。

您导入证书有两个原因：将其添加到受信任的证书列表中，以及导入从证书颁发机构 (CA) 收到的证书回复，作为向该 CA 提交证书签名请求 (CSR) 的结果。请参阅生成证书请求的命令中的 -certreq 命令。

导入的类型由 -alias 选项的值指示。如果别名不指向密钥条目，则 keytool 命令假定您正在添加受信任的证书条目。在这种情况下，别名不应已存在于密钥库中。如果别名确实存在，那么 keytool 命令会输出错误，因为该别名已经存在受信任的证书，并且不会导入该证书。如果 -alias 指向密钥条目，则 keytool 命令假定您正在导入证书回复。

```
-importpass
```

以下是 `-importpass` 命令的可用选项：

- {`-alias` *alias*}: 要处理的条目的别名
- [`-keypass` *arg*] : 密钥密码
- {`-keyalg` *alg*}:密钥算法名称
- {`-keysize` *size*}: 密钥位大小
- {`-keystore` *keystore*}: Keystore(密钥库)名称
- [`-storepass` *arg*] : Keystore(密钥库)密码
- {`-storetype` *type*}: Keystore(密钥库)类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}: 通过受保护机制提供的密码

使用 `-importpass` 命令导入密码并将其存储在由 `-alias` 标识的新 `KeyStore.SecretKeyEntry` 中。 密码短语可以通过标准输入流提供； 否则会提示用户。 `-keypass` 选项提供了一个密码来保护导入的密码。 如果未提供密码，则会提示用户输入密码。 如果您在提示符处按下 **Return** 键，则密钥密码将设置为与用于 `keystore` 的密码相同。 `-keypass` 值必须至少包含六个字符。

## 从另一个密钥库导入内容的命令

```
-importkeystore
```

以下是 `-importkeystore` 命令的可用选项：

- `-srckeystore` *keystore*: 源keystore(密钥库)名称
- {`-destkeystore` *keystore*}: 目标keystore(密钥库名称
- {`-srcstoretype` *type*}: 源密钥库类型
- {`-deststoretype` *type*}: 目标密钥库类型
- [`-srcstorepass` *arg*] : 源密钥库密码
- [`-deststorepass` *arg*] : 目标密钥库密码
- {`-srcprotected`}: 源密钥库密码保护
- {`-destprotected`}: 目标密钥库密码保护
- {`-srcprovidername` *name*}: 源密钥库提供程序名称
- {`-destprovidername` *name*}: 目标密钥库提供程序名称
- {`-srcalias` *alias*}: 源别名
- {`-destalias` *alias*}: 目的地别名
- [`-srckeypass` *arg*] : 源密钥密码
- [`-destkeypass` *arg*] : 目标密钥密码
- {`-noprompt`}: 不提示
- {`-addprovider` *name* [`-providerarg` *arg*]: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出

**注意:**

这是所有选项的第一行：

> `-srckeystore` *keystore* `-destkeystore` *keystore*

使用 `-importkeystore` 命令将单个条目或所有条目从源密钥库导入到目标密钥库。

**注意:**

如果在使用 `keytool -importkeystore` 命令时未指定 `-destkeystore`，则使用的默认密钥库是 `$HOME/.keystore`。

当提供 `-srcalias` 选项时，该命令会将别名标识的单个条目导入目标密钥库。如果 `-destalias` 未提供目标别名，则使用 `-srcalias` 作为目标别名。如果源条目受密码保护，则使用 `-srckeypass` 来恢复该条目。如果未提供 `-srckeypass`，则 `keytool` 命令会尝试使用 `-srcstorepass` 来恢复条目。如果 `-srcstorepass` 未提供或不正确，则会提示用户输入密码。目标条目受 `-destkeypass` 保护。如果未提供 `-destkeypass`，则目标条目受源条目密码保护。例如，大多数第三方工具要求 PKCS #12 密钥库中的 `storepass` 和 `keypass` 相同。要为这些工具创建 PKCS#12 密钥库，请始终指定与 `-deststorepass` 相同的 `-destkeypass`。

如果未提供 `-srcalias` 选项，则源密钥库中的所有条目都将导入目标密钥库。每个目标条目都存储在源条目的别名下。如果源条目受密码保护，则使用 `-srcstorepass` 来恢复该条目。如果 `-srcstorepass` 未提供或不正确，则会提示用户输入密码。如果目标密钥库不支持源密钥库条目类型，或者在将条目存储到目标密钥库时发生错误，则会提示用户跳过该条目并继续或退出。目标条目受源条目密码保护。

如果目标别名已存在于目标密钥库中，则会提示用户覆盖该条目或以不同的别名创建一个新条目。

如果提供了 `-noprompt` 选项，则不会提示用户输入新的目标别名。现有条目将被目标别名覆盖。无法导入的条目将被跳过并显示警告。

## 生成证书请求的命令

```
-certreq
```

以下是 `-certreq` 命令的可用选项：

- {`-alias` *alias*}: 要处理的条目的别名
- {`-sigalg` *alg*}: 签名算法名称
- {`-file` *file*}: 输出文件名
- [ `-keypass` *arg*] : 密钥密码
- {`-keystore` *keystore*}: 密钥库名称
- {`-dname` *name*}: 专有名称
- {`-ext` *value*}: X.509 扩展
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: 密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}: 通过受保护机制提供的密码

使用 `-certreq` 命令生成使用 PKCS #10 格式的证书签名请求 (CSR)。

CSR 旨在发送给 CA。 CA 对证书请求者进行身份验证（通常离线）并返回证书或证书链以替换密钥库中现有的证书链（最初是自签名证书）。

与 *alias* 关联的私钥用于创建 PKCS #10 证书请求。要访问私钥，必须提供正确的密码。如果 `-keypass` 未在命令行中提供，并且与用于保护密钥库完整性的密码不同，则会提示用户输入。如果提供了 `-dname`，则将其用作 CSR 中的主题。否则，使用与别名关联的 X.500 可分辨名称。

`-sigalg` 值指定用于签署 CSR 的算法。

CSR 存储在 `-file` *file* 中。如果未指定文件，则将 CSR 输出到 `-stdout`。

使用 `-importcert` 命令从 CA 导入响应。

## 导出数据的命令

```
-exportcert
```

以下是 `-exportcert` 命令的可用选项：

- {`-rfc`}: 以 RFC 样式输出
- {`-alias` *alias*}: 要处理的条目的别名
- {`-file` *file*}: 输出文件名
- {`-keystore` *keystore*}: 密钥库名称
- {`-cacerts`}: 访问 cacerts 密钥库
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: 密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*] }: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}:通过受保护机制提供的密码

使用 `-exportcert` 命令从与 `-alias` *alias* 关联的密钥库中读取证书，并将其存储在 `-file` *file* 中。 未指定文件时，将证书输出到`stdout`。

默认情况下，证书以二进制编码输出。 如果指定了 `-rfc` 选项，则以 Internet RFC 1421 证书编码标准定义的可打印编码格式输出。

如果 `-alias` 指的是受信任的证书，则输出该证书。 否则，“-alias”指的是具有关联证书链的密钥条目。 在这种情况下，将返回链中的第一个证书。 该证书验证由“-alias”寻址的实体的公钥。

## 显示数据的命令

```
-list
```

以下是 `-list` 命令的可用选项：

- {`-rfc`}: 以 RFC 样式输出
- {`-alias` *alias*}: 要处理的条目的别名
- {`-keystore` *keystore*}: 密钥库名称
- {`-cacerts`}: 访问 cacerts 密钥库
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: 密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*] }: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}: 通过受保护机制提供的密码

使用 `-list` 命令将由 `-alias` 标识的密钥库条目的内容打印到 `stdout`。 如果 `-alias` *alias* 未指定，则打印整个密钥库的内容。

默认情况下，此命令打印证书的 SHA-256 指纹。 如果指定了 `-v` 选项，则证书以人类可读的格式打印，并带有其他信息，例如所有者、颁发者、序列号和任何扩展名。 如果指定了 `-rfc` 选项，则使用 Internet RFC 1421 证书编码标准定义的可打印编码格式打印证书内容。

**注意:**

您不能在同一命令中同时指定 `-v` 和 `-rfc`。 否则会报错。

```
-printcert
```

以下是 `-printcert` 命令的可用选项：

- {`-rfc`}: 以 RFC 样式输出
- {`-file` *cert_file*}: 输入文件名
- {`-sslserver` *server*[`:`*port*]}:: 安全套接字层 (SSL) 服务器主机和端口
- {`-jarfile` *JAR_file*}:签名的`.jar`文件
- {`-keystore` *keystore*}: 密钥库名称
- {`-trustcacerts`}: 来自 cacerts 的信任证书
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: 密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-protected`}: 密码是通过受保护的机制提供的
- {`-v`}: 详细输出

使用 `-printcert` 命令从 `-file` *cert_file*、位于 `-sslserver` *server*[`:`*port*] 的 SSL 服务器或指定的签名 JAR 文件中读取和打印证书 `-jarfile` *JAR_file*。 它以人类可读的格式打印其内容。 如果未指定端口，则假定为标准 HTTPS 端口 443。

**注意:**

`-sslserver` 和 `-file` 选项不能在同一个命令中提供。 否则会报错。 如果您不指定任何一个选项，则从 `stdin` 读取证书。

当指定了`-rfc` 时，`keytool` 命令以 Internet RFC 1421 证书编码标准定义的 PEM 模式打印证书。

如果证书是从文件或“stdin”中读取的，则它可能是二进制编码或可打印的编码格式，如 RFC 1421 证书编码标准所定义。

如果 SSL 服务器位于防火墙后面，则可以在命令行上为代理隧道指定 `-J-Dhttps.proxyHost=proxyhost` 和 `-J-Dhttps.proxyPort=proxyport` 选项。

**注意:**

此命令可以独立于密钥库使用。 如果证书是用户密钥库（由 `-keystore` 指定）或 `cacerts` 密钥库（如果指定了 `-trustcacerts`）中的受信任证书，此命令不会检查证书签名算法的弱点。

```
-printcertreq
```

以下是 `-printcertreq` 命令的可用选项：

- {`-file` *file*}: 输入文件名
- {`-v`}: 详细输出

使用 `-printcertreq` 命令打印 PKCS #10 格式证书请求的内容，可以通过 `keytool -certreq` 命令生成。 该命令从文件中读取请求。 如果没有文件，则从标准输入读取请求。

```
-printcrl
```

以下是 `-printcrl` 命令的可用选项：

- {`-file crl`}: I输入文件名
- {`-keystore` *keystore*}: 密钥库名称
- {`-trustcacerts`}: 来自 cacerts 的信任证书
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: Keystore type
- {`-providername` *name*}: 密钥库类型
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-protected`}: 密码是通过受保护的机制提供的
- {`-v`}: 详细输出

使用 `-printcrl` 命令从 `-file crl` 读取证书吊销列表 (CRL)。 CRL 是由颁发它们的 CA 吊销的数字证书的列表。 CA 生成“crl”文件。

**注意:**

此命令可以独立于密钥库使用。 此命令尝试使用来自用户密钥库（由 `-keystore` 指定）或 `cacerts` 密钥库（如果指定了 `-trustcacerts`）的证书来验证 CRL，如果无法验证，将打印出警告。

## 管理密钥库的命令

```
-storepasswd
```

以下是 `-storepasswd` 命令的可用选项：

- [`-new` *arg*] : 新密码
- {`-keystore` *keystore*}: 密钥库名称
- {`-cacerts`}: 访问 cacerts 密钥库
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: 密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出

使用 `-storepasswd` 命令更改用于保护密钥库内容完整性的密码。 新密码由 `-new` *arg* 设置，并且必须包含至少六个字符。

```
-keypasswd
```

以下是 `-keypasswd` 命令的可用选项：

- {`-alias` *alias*}: 要处理的条目的别名
- [`-keypass` *old_keypass*] : 密钥密码
- [`-new` *new_keypass*] : 新密码
- {`-keystore` *keystore*}: 密钥库名称
- {`-storepass` *arg*}: 密钥库密码
- {`-storetype` *type*}:密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出

使用 `-keypasswd` 命令将密码（由 `-alias` 标识的私钥/密钥受到保护）从 `-keypass` *old_keypass* 更改为 `-new` *new_keypass*。 密码值必须至少包含六个字符。

如果 `-keypass` 选项未在命令行中提供，并且 `-keypass` 密码与密钥库密码 (`-storepass` *arg*) 不同，则会提示用户输入。

如果命令行中没有提供 `-new` 选项，则会提示用户输入它。

```
-delete
```

以下是 `-delete` 命令的可用选项：

- [`-alias` *alias*] : 要处理的条目的别名
- {`-keystore` *keystore*}: 密钥库名称
- {`-cacerts`}: 访问 cacerts 密钥库
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: 密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}:  通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}: 通过受保护机制提供的密码

使用 `-delete` 命令从密钥库中删除 `-alias` *alias* 条目。 如果在命令行中未提供，则会提示用户输入“别名”。

```
-changealias
```

以下是 `-changealias` 命令的可用选项：

- {`-alias` *alias*}: 要处理的条目的别名
- [`-destalias` *alias*] : 目的别名
- [`-keypass` *arg*] : 密钥密码
- {`-keystore` *keystore*}: 密钥库名称
- {`-cacerts`}: 访问 cacerts 密钥库
- [`-storepass` *arg*] : 密钥库密码
- {`-storetype` *type*}: 密钥库类型
- {`-providername` *name*}: 提供者名称
- {`-addprovider` *name* [`-providerarg` *arg*]}: 使用可选的配置参数按名称添加安全提供程序（例如 SunPKCS11）。
- {`-providerclass` *class* [`-providerarg` *arg*]}: 通过带有可选配置参数的完全限定类名添加安全提供程序。
- {`-providerpath` *list*}: 提供者类路径
- {`-v`}: 详细输出
- {`-protected`}: 通过受保护机制提供的密码

使用 `-changealias` 命令将现有的密钥库条目从 `-alias` *alias* 移动到新的 `-destalias` *alias*。 如果未提供目标别名，则该命令会提示您输入一个。 如果原始条目受条目密码保护，则可以使用 `-keypass` 选项提供密码。 如果未提供密钥密码，则首先尝试使用 `-storepass`（如果提供）。 如果尝试失败，则提示用户输入密码。

## 显示安全相关信息的命令

```
-showinfo
```

以下是 `-showinfo` 命令的可用选项：

- {`-tls`}: 显示 TLS 配置信息
- {`-v`}: 详细输出

使用 `-showinfo` 命令显示各种与安全相关的信息。 `-tls` 选项显示 TLS 配置，例如启用的协议和密码套件的列表。

## 显示程序版本的命令

您可以使用 `-version` 打印 `keytool` 的程序版本。

## 显示帮助信息的命令

您可以使用 `--help` 显示 `keytool` 命令列表或显示有关特定 `keytool` 命令的帮助信息。

- 要显示 `keytool` 命令的列表，请输入：

  > `keytool --help`

- 要显示有关特定 `keytool` 命令的帮助信息，请输入：

  > `keytool -<command> --help`

## 常用命令选项

`-v` 选项可以出现在除 `--help` 之外的所有命令中。 当 `-v` 选项出现时，它表示详细模式，这意味着输出中提供了更多信息。

`-J`*option* 参数可以出现在任何命令中。 当使用 `-J`*option* 时，指定的 *option* 字符串直接传递给 Java 解释器。 此选项不包含任何空格。 它对于调整执行环境或内存使用很有用。 有关可能的解释器选项的列表，请在命令行输入“java -h”或“java -X”。

这些选项可以出现在密钥库上运行的所有命令中：

`-storetype` *storetype*

此限定符指定要实例化的密钥库的类型。

`-keystore` *keystore*

密钥库位置。

如果使用了 JKS `storetype` 并且 keystore 文件还不存在，那么某些 `keytool` 命令可能会导致创建新的 keystore 文件。 例如，如果调用了 `keytool -genkeypair` 并且未指定 `-keystore` 选项，则在用户的主目录中创建名为 `.keystore` 的默认密钥库文件（如果它尚不存在）。 同样，如果指定了 `-keystore ks_file` 选项但 `ks_file` 不存在，则创建它。 有关 JKS `storetype` 的更多信息，请参阅 **KeyStore 别名** 中的 **KeyStore 实现** 部分。

请注意，来自 `-keystore` 选项的输入流被传递给 `KeyStore.load` 方法。 如果将“NONE”指定为 URL，则将一个空流传递给“KeyStore.load”方法。 如果密钥库不是基于文件的，则应指定“NONE”。 例如，当密钥库驻留在硬件令牌设备上时。

`-cacerts` *cacerts*

在 *cacerts* 密钥库上运行。 此选项等效于 `-keystore` *path_to_cacerts* `-storetype` *type_of_cacerts*。 如果 `-keystore` 或 `-storetype` 选项与 `-cacerts` 选项一起使用，则会报告错误。

`-storepass` [`:env` | `:file` ] *argument*

用于保护密钥库完整性的密码。

如果未指定修饰符 `env` 或 `file`，则密码的值为 *argument*，它必须包含至少六个字符。 否则，密码检索如下：

- `env`: 从名为 *argument* 的环境变量中检索密码。
- `file`: 从名为 *argument* 的文件中检索密码。

**注意:** 所有其他需要密码的选项，例如 `-keypass`、`-srckeypass`、`-destkeypass`、`-srcstorepass` 和 `-deststorepass`，都接受 `env` 和 `file` 修饰符。 请记住用冒号 (:) 分隔密码选项和修饰符。

必须为访问密钥库内容的所有命令提供密码。 对于此类命令，当命令行中未提供 `-storepass` 选项时，系统会提示用户输入该选项。

从密钥库中检索信息时，密码是可选的。 如果未指定密码，则无法验证检索到的信息的完整性并显示警告。

`-providername` *name*

用于标识安全属性文件中列出的加密服务提供者的名称。

`-addprovider` *name*

用于按名称添加安全提供程序（例如 SunPKCS11）。

`-providerclass` *class*

当服务提供者未在安全属性文件中列出时，用于指定加密服务提供者的主类文件的名称。

`-providerpath` *list*

用于指定提供者类路径。

`-providerarg` *arg*

与 `-addprovider` 或 `-providerclass` 选项一起使用，表示 *class* 名称的构造函数的可选字符串输入参数。

```
-protected=true`|`false
```

当必须通过受保护的身份验证路径（例如专用 PIN 阅读器）指定密码时，将此值指定为“真”。 因为 `-importkeystore` 命令涉及两个密钥库，所以分别为源密钥库和目标密钥库提供了以下两个选项，`-srcprotected` 和 `-destprotected`。

`-ext` {*name*{`:critical`} {`=`*value*}}

表示 X.509 证书扩展。 该选项可用于 `-genkeypair` 和 `-gencert` 以将扩展嵌入到生成的证书中，或用于 `-certreq` 以显示证书请求中请求的扩展。 该选项可以出现多次。 *name* 参数可以是支持的扩展名（请参阅 [支持的命名扩展](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#supported-named -extensions)) 或任意 OID 编号。 *value* 参数，当提供时，表示扩展的参数。 当 *value* 被省略时，扩展的默认值或扩展本身不需要参数。 `:critical` 修饰符，当提供时，意味着扩展的 `isCritical` 属性为 `true`； 否则为“假”。 您可以使用 `:c` 代替 `:critical`。

`-conf` *file*

指定预配置的选项文件。

## 预配置的选项文件

预配置的选项文件是可以使用 `-conf` 选项指定的 Java 属性文件。每个属性代表使用“keytool.*command_name*”作为属性名称的 keytool 命令的默认选项。一个名为“keytool.all”的特殊属性表示应用于所有命令的默认选项。一个属性值可以包括`${prop}`，它将被扩展为与之关联的系统属性。如果选项值内部包含空格，则应用引号（“或'）将其括起来。所有属性名称必须小写。

当使用预配置的选项文件启动 `keytool` 时，“keytool.all”的值（如果存在）首先添加到 `keytool` 命令行，并带有命令名称的值（如果存在）接下来是命令行上的现有选项。对于单值选项，这允许特定命令的属性覆盖“keytool.all”值，并在命令行上指定的值覆盖两者。对于多值选项，它们都将被 `keytool` 使用。

例如，给定以下名为 `preconfig` 的文件：

```
    # A tiny pre-configured options file
    keytool.all = -keystore ${user.home}/ks
    keytool.list = -v
    keytool.genkeypair = -keyalg rsa
```

`keytool -conf preconfig -list` 等同于

> ```
> keytool -keystore ~/ks -v -list
> ```

`keytool -conf preconfig -genkeypair -alias me` 等同于

> ```
> keytool -keystore ~/ks -keyalg rsa -genkeypair -alias me
> ```

`keytool -conf preconfig -genkeypair -alias you -keyalg ec` 等同于

> ```
> keytool -keystore ~/ks -keyalg rsa -genkeypair -alias you -keyalg ec
> ```

这相当于

> ```
> keytool -keystore ~/ks -genkeypair -alias you -keyalg ec
> ```

因为 `-keyalg` 是一个单值选项，并且在命令行中指定的 `ec` 值会覆盖预配置的选项文件。

可选值的例子:

以下示例显示了各种选项值的默认值：

```
-alias "mykey"

-keysize
    2048 (当使用 -genkeypair 并且 -keyalg 是 "RSA", "DSA", "RSASSA-PSS", 或者 "DH")
    256 (当使用 -genkeypair 并且 -keyalg 是 "EC")
    255 (当使用 -genkeypair 并且 -keyalg 是 "EdDSA", or "XDH)
    56 (当使用-genseckey 并且 -keyalg 是 "DES")
    168 (当使用 -genseckey 并且 -keyalg 是 "DESede")

-validity 90

-keystore <用户主目录中名为 .keystore 的文件>

-destkeystore <用户主目录中名为 .keystore 的文件>

-storetype <安全属性文件中“keystore.type”属性的值，由 java.security.KeyStore 中的 getDefaultType 静态方法返回>

-file
    stdin (读时)
    stdout (写时)

-protected false
```

在生成证书或证书请求时，默认签名算法（`-sigalg` 选项）是从底层私钥的算法中派生的，以提供适当的安全强度级别，如下所示：

| keyalg     | keysize  | default sigalg            |
| :--------- | :------- | ------------------------- |
| DSA        | any size | SHA256withDSA             |
| RSA        | <= 3072  | SHA256withRSA             |
|            | <= 7680  | SHA384withRSA             |
|            | > 7680   | SHA512withRSA             |
| EC         | < 384    | SHA256withECDSA           |
|            | < 512    | SHA384withECDSA           |
|            | = 512    | SHA512withECDSA           |
| RSASSA-PSS | <= 3072  | RSASSA-PSS (with SHA-256) |
|            | <= 7680  | RSASSA-PSS (with SHA-384) |
|            | > 7680   | RSASSA-PSS (with SHA-512) |
| EdDSA      | 255      | Ed25519                   |
|            | 448      | Ed448                     |
| Ed25519    | 255      | Ed25519                   |
| Ed448      | 448      | Ed448                     |

- RSASSA-PSS 签名算法使用“MessageDigest”算法作为其散列和 MGF1 算法。
- EdDSA 支持 2 种密钥大小：Ed25519 和 Ed448。 当使用 `-keyalg EdDSA` 生成 EdDSA 密钥对时，用户可以指定 `-keysize 255` 或 `-keysize 448` 来生成 Ed25519 或 Ed448 密钥对。 当没有指定 `-keysize` 时，会生成 Ed25519 密钥对。 用户还可以直接指定 `-keyalg Ed25519` 或 `-keyalg Ed448` 来生成具有预期密钥大小的密钥对。

**注意:**

为了提高开箱即用的安全性，每个 JDK 版本都会定期将默认密钥大小和签名算法名称更新为更强的值。 如果与旧版本 JDK 的互操作性很重要，请确保这些版本支持默认值。 或者，您可以使用 `-keysize` 或 `-sigalg` 选项覆盖默认值，风险自负。

## 支持的命名扩展

`keytool` 命令支持这些命名扩展。 名称不区分大小写。

- `BC` or `BasicContraints`

  值：

  完整的形式是`ca:`{`true`|`false`}[`,pathlen:`*len*] 或*len*，是`ca:true,pathlen:`*len*的缩写。 

  当 *len* 被省略时，结果值为 `ca:true`。

- `KU` or `KeyUsage`

  值：

  *usage*(`,` *usage*)*

  *usage* 可以是以下之一：

  - `digitalSignature`
  - `nonRepudiation` (`contentCommitment`)
  - `keyEncipherment`
  - `dataEncipherment`
  - `keyAgreement`
  - `keyCertSign`
  - `cRLSign`
  - `encipherOnly`
  - decipherOnly

  

   如果没有歧义，*usage* 参数可以用前几个字母缩写（例如 `dig` 表示 `digitalSignature`）或驼峰式（例如 `dS` 表示 ` digitalSignature` 或 `cRLS` 用于 `cRLSign`）。 *usage* 值区分大小写。

- `EKU` or `ExtendedKeyUsage`

  值：

  *usage*(`,` *usage*)*

  *usage* 可以是以下之一：

  - `anyExtendedKeyUsage`

  - `serverAuth`

  - `clientAuth`

  - `codeSigning`

  - `emailProtection`

  - `timeStamping`

  - `OCSPSigning`

  - 任何 OID 字符串提供 

    如果没有歧义，*usage* 参数可以用前几个字母或驼峰式风格缩写。 *usage* 值区分大小写。

- `SAN` or `SubjectAlternativeName`

  值：

  *type*`:`*value*(`,` *type*`:`*value*)

  *type* 可以是以下之一：

  - `EMAIL`

  -  `URI`

  -  `DNS`

  -  `IP`

  -  `OID `

    *value* 参数是 *type* 的字符串格式值。

- `IAN` or `IssuerAlternativeName`

  值: 

  和 `SAN` or `SubjectAlternativeName`一样.

- `SIA` or `SubjectInfoAccess`

  值:

  *模式*`:`*location-type*`:`*location-value*(`,` *method*`:`*location-type*`:`*location-value*)*

  *模式*可以是以下之一：

  - `timeStamping`

  - `caRepository`

  - Any OID

    *location-type* 和 *location-value* 参数可以是 `SubjectAlternativeName` 扩展支持的任何 *type*`:`*value*。

- `AIA` or `AuthorityInfoAccess`

  值:

  和 `SIA` or `SubjectInfoAccess`一样.

  *method* 参数可以是以下之一：

  - `ocsp`

  - `caIssuers`
  - Any OID

当 *name* 为 OID 时，该值为扩展的 `extnValue` 的十六进制转储的定义编码规则 (DER) 编码，不包括 OCTET STRING 类型和长度字节。除了标准的十六进制数字（0-9、a-f、A-F）之外，HEX 字符串中的任何额外字符都将被忽略。因此，01:02:03:04 和 01020304 都被接受为相同的值。当没有值时，扩展有一个空值字段。

仅在 `-gencert` 中使用的特殊名称`honored` 表示应如何尊重证书请求中包含的扩展。此名称的值是逗号分隔的 `all` 列表（支持所有请求的扩展名），*name*{`:`[`critical`|`non-critical`]}（支持命名的扩展名，但它使用不同的 `isCritical` 属性）和 `-name`（与 `all` 一起使用，表示异常）。默认情况下不接受请求的扩展。

如果除了`-ext Honored` 选项之外，还提供了另一个命名或OID `-ext` 选项，则此扩展名将添加到那些已被接受的扩展名中。但是，如果此名称（或 OID）也出现在Honored的值中，则其值和关键性会覆盖请求中的值。如果通过名称或 OID 多次提供相同类型的扩展，则仅使用最后一个扩展。

`subjectKeyIdentifier` 扩展总是被创建。对于非自签名证书，会创建“authorityKeyIdentifier”。

**警告:**

用户应注意某些扩展组合（和其他证书字段）可能不符合 Internet 标准。 请参阅 [证书一致性警告](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#certificate-conformance-warning)。

## 创建密钥库中的任务示例

以下示例描述了创建用于管理来自受信任实体的公钥/私钥对和证书的密钥库的顺序操作。

- [Generating the Key Pair](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#generating-the-key-pair)
- [Requesting a Signed Certificate from a CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#requesting-a-signed-certificate-from-a-ca)
- [Importing a Certificate for the CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-a-certificate-for-the-ca)
- [Importing the Certificate Reply from the CA](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-the-certificate-reply-from-the-ca)
- [Exporting a Certificate That Authenticates the Public Key](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#exporting-a-certificate-that-authenticates-the-public-key)
- [Importing the Keystore](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#importing-the-keystore)
- [Generating Certificates for an SSL Server](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html#generating-certificates-for-an-ssl-server)

### 生成密钥对

创建密钥库，然后生成密钥对。

您可以将命令作为单行输入，如下所示：

> ```
> keytool -genkeypair -dname "cn=myname, ou=mygroup, o=mycompany, c=mycountry" -alias business -keyalg rsa -keypass` *password* `-keystore /working/mykeystore -storepass password -validity 180
> ```

该命令在工作目录中创建名为 `mykeystore` 的密钥库（前提是它不存在），并为其分配由 `-keypass` 指定的密码。 它为可分辨名称为“myname”、“mygroup”、“mycompany”和“mycountry”的两个字母国家代码的实体生成一个公钥/私钥对。 它使用 RSA 密钥生成算法来创建密钥； 都是 2048 位。

该命令使用默认的 SHA256withRSA 签名算法来创建包含公钥和专有名称信息的自签名证书。 该证书的有效期为 180 天，并与“-alias business”引用的密钥库条目中的私钥相关联。 私钥被分配了由 `-keypass` 指定的密码。

当接受选项默认值时，该命令显著缩短。 在这种情况下，只需要 `-keyalg`，默认值用于具有默认值的未指定选项。 系统会提示您输入任何必需的值。 你可以有以下内容：

> ```
> keytool -genkeypair -keyalg rsa
> ```

在这种情况下，将创建一个别名为“mykey”的密钥库条目，其中包含一个新生成的密钥对和一个有效期为 90 天的证书。 此条目位于您的主目录中名为 `.keystore` 的密钥库中。 如果 `.keystore` 尚不存在，则创建它。 系统将提示您输入可分辨名称信息、密钥库密码和私钥密码。

**注意:**

其余示例假定您以与第一个“-genkeypair”命令中指定的值相等的值响应提示。 例如，可分辨名称 `cn=`*myname*`、ou=`*mygroup*`、o=`*mycompany*`、c=`*mycountry*）。

### 向 CA 请求签名证书

**注意:**

生成密钥对创建了一个自签名证书； 但是，当证书由 CA 签名时，它更有可能被其他人信任。

要获取 CA 签名，请完成以下过程：

1. 生成一个 CSR:

   > `keytool -certreq -file myname.csr`

   这将为默认别名“mykey”标识的实体创建一个 CSR，并将请求放入名为“myname.csr”的文件中。

2. 将“myname.csr”提交给 CA，例如 DigiCert。

CA 对您、请求者（通常离线）进行身份验证，并返回由他们签名的证书，以验证您的公钥。 在某些情况下，CA 返回一个证书链，每个证书都验证链中前一个证书的签名者的公钥。

### 为 CA 导入证书

要为 CA 导入证书，请完成以下过程：

1. 在从 CA 导入证书回复之前，您需要在您的密钥库或 `cacerts` 密钥库文件中拥有一个或多个受信任的证书。 请参阅 **Commands** 中的 `-importcert`。

   - 如果证书回复是证书链，那么您需要链的顶部证书。 对 CA 的公钥进行身份验证的根 CA 证书。
   - 如果证书回复是单个证书，那么您需要颁发 CA（签署它的 CA）的证书。 如果该证书不是自签名的，那么您需要其签名者的证书，依此类推，直至自签名根 CA 证书。

   `cacerts` 密钥库附带一组由 [Oracle Java 根证书程序](http://www.oracle.com/technetwork/java/javase/javasecarootcertsprogram-1876540.html) 的 CA 颁发的根证书。 如果您从 CA 请求签名证书，并且尚未将验证该 CA 公钥的证书添加到“cacerts”，那么您必须从该 CA 导入证书作为可信证书。

   来自 CA 的证书通常是自签名的或由另一个 CA 签名的。 如果它由另一个 CA 签名，您需要一个证书来验证该 CA 的公钥。

   例如，您从一家 CA 公司获得了一个 *X*`.cer` 文件，该文件应该是一个自签名证书，用于验证该 CA 的公钥。 在将其作为可信证书导入之前，您应通过以下方式确保证书有效：

   1. 使用 `keytool -printcert` 命令或 `keytool -importcert` 命令查看它，而不使用 `-noprompt` 选项。 确保显示的证书指纹与预期的指纹匹配。
   2. 打电话给发送证书的人，并将您看到的指纹与他们显示的指纹或安全公钥存储库显示的指纹进行比较。

   只有当指纹相等时，才能确保证书在传输过程中没有被其他人的证书（例如攻击者的证书）替换。 如果发生此类攻击，并且您在导入证书之前没有检查证书，那么您将信任攻击者签署的任何内容。

2. 将自签名证书替换为证书链，其中链中的每个证书都验证链中前一个证书的签名者的公钥，直至根 CA。

   如果您相信证书是有效的，那么您可以通过输入以下命令将其添加到您的密钥库中：

   > `keytool -importcert -alias` *alias* `-file *X*`.cer`

   此命令根据 CA 证书文件中的数据在密钥库中创建一个受信任的证书条目，并将 *alias* 的值分配给该条目。

### 从 CA 导入证书回复

在您导入一个对您提交证书签名请求的 CA 的公钥进行身份验证的证书后（或者 `cacerts` 文件中已经存在这样的证书），您可以导入证书回复并使用证书链替换您的自签名证书 。

证书链是以下之一：

- 当 CA 回复是一个链时，由 CA 返回。
- 当 CA 回复是单个证书时构造。 此证书链是通过使用您导入回复的密钥库或“cacerts”密钥库文件中可用的证书回复和可信证书构建的。

例如，如果您将证书签名请求发送到 DigiCert，则可以通过输入以下命令导入他们的回复：

**注意:**

在此示例中，返回的证书名为“DCmyname.cer”。

> ```
> keytool -importcert -trustcacerts -file DCmyname.cer
> ```

### 导出验证公钥的证书

**注意:**

如果您使用 `jarsigner` 命令对 Java 归档 (JAR) 文件进行签名，那么使用该文件的客户端将需要验证您的签名。

客户端可以对您进行身份验证的一种方法是将您的公钥证书作为受信任的条目导入到他们的密钥库中。 然后，您可以导出证书并将其提供给您的客户。

例如:

1. 输入以下命令，将您的证书复制到名为“myname.cer”的文件中：

   在此示例中，该条目的别名为“mykey”。

   > `keytool -exportcert -alias mykey -file myname.cer`

2. 使用证书和签名的 JAR 文件，客户端可以使用 `jarsigner` 命令来验证您的签名。

### 导入密钥库

使用 `importkeystore` 命令将整个密钥库导入另一个密钥库。 这将使用单个命令将源密钥库中的所有条目（包括密钥和证书）导入目标密钥库。 您可以使用此命令从不同类型的密钥库中导入条目。 在导入期间，目标密钥库中的所有新条目都将具有相同的别名和保护密码（用于密钥和私钥）。 如果 `keytool` 命令无法从源密钥库中恢复私钥或密钥，则会提示您输入密码。 如果它检测到别名重复，那么它会要求您提供一个新别名，您可以指定一个新别名或简单地允许 `keytool` 命令覆盖现有别名。

例如，通过输入以下命令，将典型 JKS 类型密钥库“key.jks”中的条目导入 PKCS #11 类型基于硬件的密钥库：

> `keytool -importkeystore -srckeystore key.jks -destkeystore NONE -srcstoretype JKS -deststoretype PKCS11 -srcstorepass` *password* `-deststorepass` *password*

`importkeystore` 命令还可用于将单个条目从源密钥库导入到目标密钥库。 在这种情况下，除了前面示例中使用的选项外，您还需要指定要导入的别名。 通过指定 `-srcalias` 选项，您还可以指定目标别名、密钥或私钥的保护密码以及您想要的目标保护密码，如下所示：

> ```
> keytool -importkeystore -srckeystore key.jks -destkeystore NONE -srcstoretype JKS -deststoretype PKCS11 -srcstorepass` *password* `-deststorepass` *password* `-srcalias myprivatekey -destalias myoldprivatekey -srckeypass` *password* `-destkeypass` *password* `-noprompt
> ```

### 为 SSL 服务器生成证书

以下是用于为三个实体生成密钥对和证书的 `keytool` 命令：

- Root CA (`root`)
- Intermediate CA (`ca`)
- SSL server (`server`)

确保将所有证书存储在同一个密钥库中。

```
keytool -genkeypair -keystore root.jks -alias root -ext bc:c -keyalg rsa
keytool -genkeypair -keystore ca.jks -alias ca -ext bc:c -keyalg rsa
keytool -genkeypair -keystore server.jks -alias server -keyalg rsa

keytool -keystore root.jks -alias root -exportcert -rfc > root.pem

keytool -storepass password -keystore ca.jks -certreq -alias ca |
    keytool -storepass password -keystore root.jks
    -gencert -alias root -ext BC=0 -rfc > ca.pem
keytool -keystore ca.jks -importcert -alias ca -file ca.pem

keytool -storepass password -keystore server.jks -certreq -alias server |
    keytool -storepass password -keystore ca.jks -gencert -alias ca
    -ext ku:c=dig,kE -rfc > server.pem
cat root.pem ca.pem server.pem |
    keytool -keystore server.jks -importcert -alias server
```

## 术语

**Keystore**

Keystore(密钥库)是加密密钥和证书的存储设施。

**Keystore entries**

密钥库可以有不同类型的条目。 `keytool` 命令的两种最适用的条目类型包括：

密钥条目：每个条目都包含非常敏感的加密密钥信息，这些信息以受保护的格式存储，以防止未经授权的访问。 通常，存储在此类条目中的密钥是密钥，或者是伴随相应公钥的证书链的私钥。 请参阅**证书链**。 `keytool` 命令可以处理这两种类型的条目，而 `jarsigner` 工具只处理后一种类型的条目，即私钥及其相关的证书链。

受信任的证书条目：每个条目都包含一个属于另一方的公钥证书。 该条目被称为可信证书，因为密钥库所有者相信证书中的公钥属于证书的主体（所有者）所标识的身份。 证书的颁发者通过签署证书来保证这一点。

**Keystore aliases**

所有密钥库条目（密钥和受信任的证书条目）都通过唯一别名访问。

当您使用 `-genseckey` 命令生成密钥、使用 `-genkeypair` 命令生成密钥对（公钥和私钥）或 `-importcert` 命令将实体添加到密钥库时，会指定别名 将证书或证书链添加到受信任证书列表中。 后续的 `keytool` 命令必须使用相同的别名来引用实体。

例如，您可以使用别名 `duke` 生成新的公钥/私钥对，并使用以下命令将公钥包装到自签名证书中。 请参阅**证书链**。

> `keytool -genkeypair -alias duke -keyalg rsa -keypass` *passwd*

此示例指定后续命令所需的初始 *passwd* 以访问与别名 `duke` 关联的私钥。 如果您以后想更改 Duke 的私钥密码，请使用如下命令：

> `keytool -keypasswd -alias duke -keypass` *passwd* `-new` *newpasswd*

这会将初始 *passwd* 更改为 *newpasswd*。 不应在命令行或脚本中指定密码，除非用于测试目的，或者您在安全系统上。 如果您未在命令行上指定所需的密码选项，则会提示您输入密码。

**Keystore implementation**

`java.security` 包中提供的`KeyStore` 类提供了定义良好的接口来访问和修改密钥库中的信息。可能有多个不同的具体实现，其中每个实现都是针对特定类型的密钥库的。

目前，有两个命令行工具（`keytool` 和 `jarsigner`）使用密钥库实现。因为 `KeyStore` 类是 `public`，所以用户可以编写使用它的其他安全应用程序。

在 JDK 9 及更高版本中，默认的密钥库实现是 PKCS12。这是一个基于 RSA PKCS12 个人信息交换语法标准的跨平台密钥库。该标准主要用于存储或传输用户的私钥、证书和其他机密。 Oracle 提供了另一个内置实现。它将密钥库实现为具有名为“JKS”的专有密钥库类型（格式）的文件。它使用单独的密码保护每个私钥，并使用（可能不同的）密码保护整个密钥库的完整性。

密钥库实现是基于提供者的。更具体地说，“KeyStore”提供的应用程序接口是根据服务提供者接口 (SPI) 实现的。即有一个对应的抽象类KeystoreSpi，也在java.security包中，定义了提供者必须实现的Service Provider接口方法。术语 *provider* 指的是一个包或一组包，它们提供 Java 安全 API 可以访问的服务子集的具体实现。要提供密钥库实现，客户端必须实现提供者并提供“KeystoreSpi”子类实现，如实现和集成提供者的步骤中所述。

应用程序可以使用 `KeyStore` 类中提供的 `getInstance` 工厂方法从不同的提供者中选择不同类型的密钥库实现。密钥库类型定义了密钥库信息的存储和数据格式，以及用于保护密钥库中的私钥/秘密密钥和密钥库完整性的算法。不同类型的密钥库实现不兼容。

`keytool` 命令适用于任何基于文件的密钥库实现。它将在命令行中传递给它的密钥库位置视为文件名，并将其转换为 `FileInputStream`，从中加载密钥库信息。）`jarsigner` 命令可以从任何可以用 URL 指定的位置读取密钥库。

对于 `keytool` 和 `jarsigner`，您可以在命令行中使用 `-storetype` 选项指定密钥库类型。

如果您没有明确指定密钥库类型，则工具会根据安全属性文件中指定的 `keystore.type` 属性的值选择密钥库实现。安全属性文件称为“java.security”，位于安全属性目录中：

- **Linux and OS X:** `java.home/lib/security`
- **Windows:** `java.home\lib\security`

每个工具获取 `keystore.type` 值，然后检查所有当前安装的提供程序，直到找到实现该类型密钥库的提供程序。 然后它使用来自该提供者的密钥库实现。“KeyStore”类定义了一个名为“getDefaultType”的静态方法，它允许应用程序检索“keystore.type”属性的值。 以下代码行创建了 `keystore.type` 属性中指定的默认密钥库类型的实例：

> ```
> KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
> ```

默认密钥库类型是 `pkcs12`，它是基于 RSA PKCS12 个人信息交换语法标准的跨平台密钥库。 这由安全属性文件中的以下行指定：

> ```
> keystore.type=pkcs12
> ```

要让工具使用默认以外的密钥库实现，您可以更改该行以指定不同的密钥库类型。 例如，如果您想使用 Oracle 的 `jks` 密钥库实现，则将该行更改为以下内容：

> ```
> keystore.type=jks
> ```

**注意：**

大小写在密钥库类型指定中无关紧要。例如，`JKS` 将被视为与`jks` 相同。

**Certificate**

证书（或公钥证书）是来自一个实体（颁发者）的数字签名声明，表示另一个实体（主体）的公钥和其他一些信息具有某些特定价值。以下术语与证书有关：

- 公钥：这些是与特定实体相关联的数字，旨在让需要与该实体进行可信交互的每个人都知道。公钥用于验证签名。
- 数字签名：如果某些数据经过数字签名，则将其与实体的身份和证明实体知道数据的签名一起存储。通过使用实体的私钥签名，数据变得不可伪造。
- 身份：一种已知的寻址实体的方式。在某些系统中，身份是公钥，而在其他系统中，它可以是任何东西，从 Oracle Solaris UID 到电子邮件地址再到 X.509 专有名称。
- 签名：使用实体的私钥对某些数据计算签名。签名者，在证书的情况下也称为颁发者。
- 私钥：这些是数字，每个数字都应该只有其私钥所在的特定实体才知道（也就是说，它应该保密）。在所有公钥密码系统（也称为公钥密码系统）中，私钥和公钥成对存在。在典型的公钥密码系统中，例如 DSA，一个私钥恰好对应一个公钥。私钥用于计算签名。
- 实体：实体是个人、组织、程序、计算机、企业、银行或您在某种程度上信任的其他事物。

公钥加密需要访问用户的公钥。在大规模网络环境中，不可能保证通信实体之间已经建立了先前的关系，或者不可能保证存在具有所有使用的公钥的可信存储库。发明证书是为了解决这个公钥分发问题。现在，证书颁发机构 (CA) 可以充当受信任的第三方。 CA 是实体，例如受信任为其他实体签署（颁发）证书的企业。假设 CA 仅创建有效且可靠的证书，因为它们受法律协议的约束。有许多公共证书颁发机构，例如 DigiCert、Comodo、Entrust 等。

您还可以使用 Microsoft 证书服务器或您组织的 Entrust CA 产品等产品运行您自己的证书颁发机构。使用 `keytool` 命令，可以显示、导入和导出证书。也可以生成自签名证书。

`keytool` 命令当前处理 X.509 证书。

**X.509 Certificates**

X.509 标准定义了可以进入证书的信息并描述了如何将其写下来（数据格式）。 证书中的所有数据都使用称为 ASN.1/DER 的两个相关标准进行编码。 抽象语法符号 1 描述数据。 明确编码规则描述了存储和传输该数据的单一方式。

除签名外，所有 X.509 证书都具有以下数据：

- 版本：这标识了适用于该证书的 X.509 标准的哪个版本，这会影响可以在其中指定哪些信息。到目前为止，定义了三个版本。 `keytool` 命令可以导入和导出 v1、v2 和 v3 证书。它生成 v3 证书。

  - X.509 版本 1 自 1988 年以来一直可用，被广泛部署，并且是最通用的。
  - X.509 版本 2 引入了主题和颁发者唯一标识符的概念，以处理随时间重复使用主题或颁发者名称的可能性。大多数证书配置文件强烈建议不要重复使用名称，并且证书不应使用唯一标识符。版本 2 证书没有被广泛使用。
  - X.509 版本 3 是最新的（1996 年），支持扩展的概念，任何人都可以定义扩展并将其包含在证书中。一些常见的扩展是：KeyUsage（将密钥的使用限制为特定目的，例如“仅签名”）和 AlternativeNames（允许其他身份也与此公钥相关联，例如。DNS 名称、电子邮件地址、IP 地址）。可以将扩展标记为critical ，以指示应该检查和强制执行或使用扩展。例如，如果证书的 KeyUsage 扩展标记为critical 并设置为“keyCertSign”，那么当此证书在 SSL 通信期间出现时，它应该被拒绝，因为证书扩展表明关联的私钥只能用于签署证书而不是用于 SSL。

- 序列号：创建证书的实体负责为其分配一个序列号，以将其与它颁发的其他证书区分开来。 该信息以多种方式使用。 例如，当证书被吊销时，其序列号被放置在证书吊销列表 (CRL) 中。

- 签名算法标识符：标识 CA 用于签署证书的算法。

- 颁发者名称：签署证书的实体的 X.500 专有名称。 这通常是 CA。 使用此证书意味着信任签署此证书的实体。 在某些情况下，例如根证书或顶级 CA 证书，颁发者会签署自己的证书。

- 有效期：每个证书仅在有限的时间内有效。 这段时间由开始日期和时间以及结束日期和时间来描述，可以短至几秒，也可以几乎长至一个世纪。 选择的有效期取决于许多因素，例如用于签署证书的私钥的强度，或者愿意为证书支付的金额。当相关的私钥没有被泄露时， 这是实体可以依赖公共值的预期时期。

- 主题名称：证书标识其公钥的实体的名称。 此名称使用 X.500 标准，因此它在 Internet 上是唯一的。 这是实体的 X.500 可分辨名称 (DN)。 例如，

  > `CN=Java Duke, OU=Java Software Division, O=Oracle Corporation, C=US`

  这些是指主题的通用名称 (CN)、组织单位 (OU)、组织 (O) 和国家 (C)。

- 主题公钥信息：这是被命名实体的公钥，带有一个算法标识符，该标识符指定该密钥属于哪个公钥密码系统以及任何相关的密钥参数。

**Certificate Chains**

`keytool` 命令可以创建和管理密钥库密钥条目，每个条目都包含一个私钥和一个关联的证书链。链中的第一个证书包含对应于私钥的公钥。

首次生成密钥时，链通常开始包含单个元素，即自签名证书。请参阅 **Commands** 中的 -genkeypair。自签名证书是颁发者（签名者）与主题相同的证书。主题是其公钥正在由证书进行身份验证的实体。当调用 `-genkeypair` 命令生成新的公钥/私钥对时，它还会将公钥包装到自签名证书中（除非指定了 `-signer` 选项）。

稍后，在使用 `-certreq` 命令生成证书签名请求 (CSR) 并将其发送到证书颁发机构 (CA) 后，使用 `-importcert` 导入来自 CA 的响应，并通过一系列证书替换自签名证书。链的底部是 CA 颁发的证书（回复），用于验证主题的公钥。链中的下一个证书是验证 CA 公钥的证书。

在许多情况下，这是一个自签名证书，它是来自 CA 的证书，用于验证其自己的公钥，并且是链中的最后一个证书。在其他情况下，CA 可能会返回一系列证书。在这种情况下，链中最底层的证书是相同的（由 CA 签名的证书，认证密钥条目的公钥），但链中的第二个证书是由不同的 CA 签名的证书，它对您的CSR 发送到的CA 的公钥进行认证。链中的下一个证书是对第二个 CA 的密钥进行身份验证的证书，依此类推，直到获得自签名根证书。链中的每个证书（在第一个之后）都验证链中前一个证书的签名者的公钥。

许多 CA 只返回已颁发的证书，没有支持链，尤其是当有平铺层次结构（没有中间 CA）时。在这种情况下，必须根据已存储在密钥库中的可信证书信息建立证书链。

不同的回复格式（由 PKCS #7 标准定义）除了已颁发的证书外还包括支持证书链。两种回复格式都可以通过 `keytool` 命令处理。

顶级（根）CA 证书是自签名的。但是，对根公钥的信任并非来自根证书本身，而是来自其他来源，例如报纸。这是因为任何人都可以生成具有可分辨名称的自签名证书，例如 DigiCert 根 CA。根 CA 公钥是众所周知的。它存储在证书中的唯一原因是因为这是大多数工具都能理解的格式，因此在这种情况下，证书仅用作传输根 CA 的公钥的工具。在将根 CA 证书添加到您的密钥库之前，您应该使用 `-printcert` 选项查看它，并将显示的指纹与从报纸、根 CA 的网页等获得的众所周知的指纹进行比较。

**cacerts Certificates File**

名为“cacerts”的证书文件位于安全属性目录中：

- **Linux and OS X:** *JAVA_HOME*`/lib/security`
- **Windows:** *JAVA_HOME*`\lib\security`

`cacerts` 文件表示具有 CA 证书的系统范围的密钥库。 系统管理员可以通过将 `jks` 指定为密钥库类型，使用 `keytool` 命令配置和管理该文件。 `cacerts` 密钥库文件附带一组默认的根 CA 证书。 对于 Linux、OS X 和 Windows，您可以使用以下命令列出默认证书：

> ```
> keytool -list -cacerts
> ```

`cacerts` 密钥库文件的初始密码是 `changeit`。 系统管理员应在安装 SDK 时更改该密码和该文件的默认访问权限。

**注意:**

验证您的 `cacerts` 文件很重要。因为您信任 `cacerts` 文件中的 CA 作为向其他实体签名和颁发证书的实体，所以必须小心管理 `cacerts` 文件。 `cacerts` 文件应该只包含您信任的 CA 的证书。您有责任验证捆绑在“cacerts”文件中的受信任的根 CA 证书并做出自己的信任决定。

要从 `cacerts` 文件中删除不受信任的 CA 证书，请使用 `keytool` 命令的 `-delete` 选项。您可以在 JDK 的 `$JAVA_HOME/lib/security` 目录中找到 `cacerts` 文件。如果您无权编辑此文件，请联系您的系统管理员。

**Internet RFC 1421 Certificate Encoding Standard**

证书通常使用 Internet RFC 1421 标准定义的可打印编码格式存储，而不是二进制编码。这种证书格式，也称为 Base64 编码，可以很容易地通过电子邮件或其他机制将证书导出到其他应用程序。

`-importcert` 和 `-printcert` 命令读取的证书可以采用这种格式或二进制编码。 `-exportcert` 命令默认以二进制编码输出证书，但当指定 `-rfc` 选项时，将改为以可打印编码格式输出证书。

`-list` 命令默认打印证书的 SHA-256 指纹。如果指定了 `-v` 选项，则证书以人类可读的格式打印。如果指定了 `-rfc` 选项，则证书以可打印的编码格式输出。

在其可打印的编码格式中，编码证书的开头和结尾由以下文本限定：

```
-----BEGIN CERTIFICATE-----

encoded certificate goes here.

-----END CERTIFICATE-----
```

**X.500 Distinguished Names**

X.500 可分辨名称用于标识实体，例如由 X.509 证书的“主题”和“颁发者”（签名者）字段命名的实体。 `keytool` 命令支持以下子部分：

- commonName：一个人的通用名，例如 Susan Jones。
- organizationUnit：小组织（如部门或部门）的名称。 例如，采购。
- localityName：地区（城市）名称，例如帕洛阿尔托。
- stateName：州或省名称，例如加利福尼亚。
- country：两个字母的国家代码，例如 CH。

当您提供专有名称字符串作为 `-dname` 选项的值时，例如对于 `-genkeypair` 命令，该字符串必须采用以下格式：

> ```
> CN=cName, OU=orgUnit, O=org, L=city, S=state, C=countryCode
> ```

以下所有项目代表实际值，前面的关键字是以下内容的缩写：

```
CN=commonName
OU=organizationUnit
O=organizationName
L=localityName
S=stateName
C=country
```

一个示例可分辨名称字符串是：

> ```
> CN=Mark Smith, OU=Java, O=Oracle, L=Cupertino, S=California, C=US
> ```

使用这样一个字符串的示例命令是：

> ```
> keytool -genkeypair -dname "CN=Mark Smith, OU=Java, O=Oracle, L=Cupertino, S=California, C=US" -alias mark -keyalg rsa
> ```

关键字缩写的大小写无关紧要。 例如，CN、cn 和 Cn 都被同等对待。

订单事项； 每个子组件必须以指定的顺序出现。 但是，不必拥有所有子组件。 您可以使用子集，例如：

> ```
> CN=Smith, OU=Java, O=Oracle, C=US
> ```

如果专有名称字符串值包含逗号，则在命令行上指定字符串时，逗号必须用反斜杠 (\\) 字符转义，如下所示：

> ```
> cn=Jack, ou=Java\, Product Development, o=Oracle, c=US
> ```

没有必要在命令行上指定专有名称字符串。 当命令需要可分辨名称但未在命令行上提供时，系统会提示用户输入每个子组件。 在这种情况下，逗号不需要用反斜杠 (\\) 转义。

## 警告

### 导入可信证书警告

**Important**: 在将证书作为可信证书导入之前，请务必仔细检查证书。

**Windows Example:**

首先使用 `-printcert` 命令或不带 `-noprompt` 选项的 `-importcert` 命令查看证书。 确保显示的证书指纹与预期指纹匹配。 例如，假设有人向您发送或通过电子邮件发送一个证书，您将其放入名为 `\tmp\cert` 的文件中。 在考虑将证书添加到受信任证书列表之前，您可以执行“-printcert”命令来查看其指纹，如下所示：

```
  keytool -printcert -file \tmp\cert
    Owner: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Issuer: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Serial Number: 59092b34
    Valid from: Thu Jun 24 18:01:13 PDT 2016 until: Wed Jun 23 17:01:13 PST 2016
    Certificate Fingerprints:

                   SHA-1: 20:B6:17:FA:EF:E5:55:8A:D0:71:1F:E8:D6:9D:C0:37:13:0E:5E:FE
                 SHA-256: 90:7B:70:0A:EA:DC:16:79:92:99:41:FF:8A:FE:EB:90:
                          17:75:E0:90:B2:24:4D:3A:2A:16:A6:E4:11:0F:67:A4
```

**Linux Example:**

首先使用 `-printcert` 命令或不带 `-noprompt` 选项的 `-importcert` 命令查看证书。 确保显示的证书指纹与预期指纹匹配。 例如，假设有人向您发送或通过电子邮件发送证书，您将其放入名为“/tmp/cert”的文件中。 在考虑将证书添加到受信任证书列表之前，您可以执行“-printcert”命令来查看其指纹，如下所示：

```
  keytool -printcert -file /tmp/cert
    Owner: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Issuer: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Serial Number: 59092b34
    Valid from: Thu Jun 24 18:01:13 PDT 2016 until: Wed Jun 23 17:01:13 PST 2016
    Certificate Fingerprints:

                   SHA-1: 20:B6:17:FA:EF:E5:55:8A:D0:71:1F:E8:D6:9D:C0:37:13:0E:5E:FE
                   SHA-256: 90:7B:70:0A:EA:DC:16:79:92:99:41:FF:8A:FE:EB:90:
                           17:75:E0:90:B2:24:4D:3A:2A:16:A6:E4:11:0F:67:A4
```

然后致电或以其他方式联系发送证书的人，并将您看到的指纹与他们显示的指纹进行比较。 只有当指纹相等时，才能保证证书在传输过程中不会被其他人的证书（例如攻击者的证书）替换。 如果发生此类攻击，并且您在导入证书之前没有检查证书，那么您将信任攻击者签署的任何内容，例如，其中包含恶意类文件的 JAR 文件。

**注意:**

在导入证书之前不需要执行 `-printcert` 命令。 这是因为在您将证书添加到密钥库中的受信任证书列表之前，`-importcert` 命令会打印出证书信息并提示您进行验证。 然后您可以停止导入操作。 但是，只有在调用不带 `-noprompt` 选项的 `-importcert` 命令时才能执行此操作。 如果指定了 `-noprompt` 选项，则不会与用户交互。

### 密码警告

大多数在密钥库上运行的命令都需要存储密码。 某些命令需要私钥/密钥密码。 密码可以在命令行的 `-storepass` 和 `-keypass` 选项中指定。 但是，不应在命令行或脚本中指定密码，除非它用于测试，或者您使用的是安全系统。 当您没有在命令行上指定所需的密码选项时，系统会提示您输入它。

### 证书一致性警告

[Internet X.509 公钥基础结构证书和证书撤销列表 (CRL) 配置文件](https://tools.ietf.org/rfc/rfc5280.txt) 定义了一个关于符合 X.509 证书的配置文件，其中包括哪些值和 值组合对证书字段和扩展有效。

`keytool` 命令不会强制执行所有这些规则，因此它可以生成不符合标准的证书，例如用于内部测试目的的自签名证书。 不符合标准的证书可能会被 JDK 或其他应用程序拒绝。 用户应确保为 `-dname`、`-ext` 等提供正确的选项。

### 导入新的可信证书

在将证书添加到密钥库之前，keytool 命令会尝试使用密钥库中已经可用的可信证书构建从该证书到自签名证书（属于根 CA）的信任链来验证它

如果指定了 `-trustcacerts` 选项，则为信任链考虑附加证书，即名为 `cacerts` 的文件中的证书。

如果 `keytool` 命令未能建立从要导入的证书到自签名证书（从密钥库或 `cacerts` 文件）的信任路径，则打印证书信息，并提示用户通过将显示的证书指纹与从其他（受信任的）信息源（可能是证书所有者）获得的指纹进行比较来验证它。在将证书作为可信证书导入之前，请务必小心确保证书有效。然后用户可以选择停止导入操作。如果指定了 `-noprompt` 选项，则不会与用户交互。

### 导入证书回复

当您导入证书回复时，证书回复会使用来自密钥库的受信任证书进行验证，并且可以选择在指定 `-trustcacerts` 选项时使用在 `cacerts` 密钥库文件中配置的证书。

判断证书回复是否可信的方法如下：

- 如果回复是单个 X.509 证书，则“keytool”命令会尝试建立信任链，从证书回复开始，到自签名证书（属于根 CA）结束。 证书回复和证书层次结构用于验证来自新证书别名链的证书回复。 如果无法建立信任链，则不会导入证书回复。 在这种情况下，`keytool` 命令不会打印证书并提示用户进行验证，因为用户很难确定证书回复的真实性。
- 如果回复是 PKCS #7 格式的证书链或 X.509 证书序列，则该链按用户证书排序，然后是零个或多个 CA 证书。 如果链以自签名根 CA 证书结尾并且指定了 -trustcacerts 选项，则 `keytool` 命令会尝试将其与密钥库或 `cacerts` 密钥库文件中的任何受信任证书匹配。 如果链不以自签名根 CA 证书结尾并且指定了 `-trustcacerts` 选项，则 `keytool` 命令尝试从密钥库或 `cacerts` 密钥库文件中的受信任证书中查找一个并添加 它到链的末端。 如果未找到证书且未指定 `-noprompt` 选项，则打印链中最后一个证书的信息，并提示用户进行验证。

如果证书回复中的公钥与已使用“别名”存储的用户公钥匹配，则旧证书链将替换为回复中的新证书链。 旧链只能用有效的“keypass”替换，因此提供了用于保护条目私钥的密码。 如果未提供密码，并且私钥密码与密钥库密码不同，则会提示用户输入密码。

该命令在早期版本中被命名为 `-import`。 此版本仍支持此旧名称。 首选新名称“-importcert”。

[原文链接](https://docs.oracle.com/en/java/javase/18/docs/specs/man/keytool.html)