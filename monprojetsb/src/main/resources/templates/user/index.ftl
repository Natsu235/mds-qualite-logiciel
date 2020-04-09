<!-- User Index -->

<#import "/spring.ftl" as spring/>

<head>
  <#include "../includable/bootstrap.ftl">
</head>

<body>
  <#if page??>
    <h1> ${page} </h1>
  </#if>
  <form action="create">
    <input type="submit" value="Add a new user" />
  </form>
  <table class="table table-bordered table-hover">
    <tr>
      <th>Firstname: </th>
      <th>Lastname: </th>
    </tr>
    <#list items as item>
      <tr>
        <td>${item.firstname}</td>
        <td>${item.lastname}</td>
        <td><a href="show/${item["id"]}">Show</a></td>
        <td>
          <form action="delete" method="POST">
            <input type="hidden" name="id" value="${item["id"]}" />
            <input type="submit" value="Delete" />
          </form>
        </td>
      </tr>
    </#list>
  </table>
</body>
