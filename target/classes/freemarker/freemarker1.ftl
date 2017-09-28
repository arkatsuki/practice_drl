
// 传入的参数是个map，下面这种形式判断是否有ruleList这个key
<#if ruleList ??>
go in if
// ruleList对应的value是一个List<Rule>，可以遍历
<#list ruleList as rule>
go in list iterate
// 用“.”取对象的属性值
rule "${rule.code}"
    when
        ${rule.name}
    then
        ok

end
</#list>
</#if>
end