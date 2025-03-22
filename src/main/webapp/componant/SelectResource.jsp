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
            <div class="card-body">
<select name="resources" class="selectpicker form-control m-5 w-50" multiple data-live-search="true" data-actions-box="true">
    <optgroup label="Resources">
        <c:forEach var="resource" items="${resources}">
            <option>${resource.getResourceName()}</option>
        </c:forEach>
    </optgroup>
</select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <input type="submit" class="btn btn-success" value="Add">
            </div>
        </div>

    </div>
</div>