<!-- Show User -->

<#import "/spring.ftl" as spring/>

<head>
  <#include "../includable/bootstrap.ftl">
</head>
<body>
  <#if page??>
    <h1>${page}</h1>
  </#if>
    <form action="index">
      <input type="submit" value="Show users list" />
    </form>
    <br>
    <span>User ID: ${user.id}</span><br>
    <span>User Firstname: ${user.firstname}</span><br>
    <span>User Lastname: ${user.lastname}</span>
</body>
