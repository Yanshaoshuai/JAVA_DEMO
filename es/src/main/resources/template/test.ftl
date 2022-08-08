<namespace com.es.mapper.TestMapper>


<search method="getByName">
{
  "size": 1,
  "query": {
    "bool": {
      "must": [
        {
          "term": {
            "name.keyword": {
              "value": "${name}"
            }
          }
        }
      ]
    }
  }
}
</search>
<search method="getByAge">
{
  "size": 1,
  "query": {
    "bool": {
      "must": [
        {
          "term": {
            "age": {
              "value": ${age}
            }
          }
        }
      ]
    }
  }
}
</search>
</namespace>

