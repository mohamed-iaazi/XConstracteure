<%--
  Created by IntelliJ IDEA.
  User: iaazi
  Date: 21/03/2025
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<div class="modal fade" id="AssociateResource" tabindex="-1" aria-labelledby="AssociateResourceModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="card px-1 py-4">
            <div class="card-body">
<select name="resources" class="selectpicker form-control" multiple data-live-search="true" data-actions-box="true">
    <optgroup label="Resources">
        <c:forEach var="resource" items="${resources}">
            <option>${resource.getResourceName()}</option>
        </c:forEach>
    </optgroup>
</select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <input name="action" value="UpdateProject" type="submit" class="btn btn-success">
            </div>
        </div>
    </div>
</div>



