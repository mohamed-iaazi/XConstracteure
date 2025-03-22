<%--
  Created by IntelliJ IDEA.
  User: iaazi
  Date: 22/03/2025
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<div class="dropdown">
    <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-eye text-light"></i>
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <c:forEach var="resource" items="${resources}">
        <a class="dropdown-item" href="#">${resource.getResourceName()}</a>
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>

        </c:forEach>


    </div>
</div>