<!--Product Create -->

<#import "/spring.ftl" as spring/>

<head>
  <#include "../includable/bootstrap.ftl">
</head>
<body>
  <#if page??>
    <h1>${page}</h1>
  </#if>
  <form action="create">
    <input type="submit" value="Show products list" />
  </form>
  <form action="<@spring.url '/product/create'/>" method="POST">
    <span>Name: </span><br>
    <input type="text" name="name" value="" />
    <br>
    <span>Price: </span><br>
    <input type="text" name="price" value="" />
    <br>
    <input type="submit" value="Confirm" />
  </form>
</body>
