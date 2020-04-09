<!-- User Create -->

<#import "/spring.ftl" as spring/>

<head>
  <#include "../includable/bootstrap.ftl">
</head>

<body>
  <#if page??>
    <h1>${page}</h1>
  </#if>
  <form action="create">
    <input type="submit" value="Show users list" />
  </form>
  <form action="<@spring.url '/user/create'/>" method="POST">
    <span>Firstname: </span><br>
    <input type="text" name="firstname" value="" />
    <br>
    <span>Lastname: </span><br>
    <input type="text" name="lastname" value="" />
    <br>
    <input type="submit" value="Confirm" />
  </form>
</body>
