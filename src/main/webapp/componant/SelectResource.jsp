<%--
  Created by IntelliJ IDEA.
  User: iaazi
  Date: 21/03/2025
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<div class="modal fade" id="AssociateResource" tabindex="-1" aria-labelledby="AssociateResourceModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="AssociateResourceModal">Associate des Resource</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="${pageContext.request.contextPath}/ProjectDetail" method="POST">
                    <input type="hidden" name="action" value="AssociateToResource">
                    <input type="hidden" name="taskId" id="taskId">
                <div class="card-body">
                    <select name="resources" class="form-control m-5 w-50" >

        <c:forEach var="resource" items="${resources}">
            <option>${resource.getResourceName()}</option>
        </c:forEach>
</select>
                    <input name="quantité" class="form-control w-50 d-block ms-auto me-auto " type="number" placeholder="quantite" required>

                </div>
            <div class="modal-footer mt-4">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <input type="submit" class="btn btn-success" value="Add">
            </div>
                </form>

            </div>

    </div>
</div>


<script>

    document.addEventListener('DOMContentLoaded', function () {
        const  selectModal = document.getElementById('AssociateResource');
        selectModal.addEventListener('show.bs.modal', function (e) {
            const  btn = e.relatedTarget;
            const  taskId = btn.getAttribute('data-TaskId');
            const  id =document.getElementById('taskId');
            id.value=taskId;



        })



    })

</script>