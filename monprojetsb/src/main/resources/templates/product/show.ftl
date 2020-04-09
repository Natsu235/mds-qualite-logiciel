<!-- Show Product -->

<#import "/spring.ftl" as spring/>

<head>
  <#include "../includable/bootstrap.ftl">
</head>
<body>
  <#if page??>
    <h1>${page}</h1>
  </#if>
    <form action="index">
      <input type="submit" value="Show products list" />
    </form>
    <br>
    <span>Product ID: ${product.id}</span><br>
    <span>Product Name: ${product.name}</span><br>
    <span>Product Price: ${product.price}</span>
</body>
