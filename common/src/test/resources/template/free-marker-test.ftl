${name!}
${age!"100"}
<#if age<=30>
    so young
</#if>
<#if children??>
    <#list children>
        <#items as child>
            ${child.name}-${child.age}
        </#items>
    </#list>
<#else>
    no children
</#if>
<#if properties??>
    <#list properties>
        <#items as key,value>
            ${key}-${value}
        </#items>
    </#list>
</#if>