<%@ page import="com.medo.xbuilder.service.project.ProjectServiceImp" %>
<%@ page import="com.medo.xbuilder.model.Project" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: iaazi
  Date: 19/03/2025
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<!-- Modal -->
<!-- Modal -->
<div class="modal fade" id="UpdateProject" tabindex="-1" aria-labelledby="UpdateProjectModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="POST" action="${pageContext.request.contextPath}/update-project">
            <input type="hidden" name="projectId" id="projectId">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="UpdateProjectModal">Update Project</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="card px-1 py-4">
                    <div class="card-body">
                        <h6 class="information mt-4">Please provide the following information</h6>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <input name="name" class="form-control" type="text" placeholder="Name" id="name">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <div class="input-group">
                                        <textarea name="description" class="form-control" placeholder="description" id="description"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input name="startdate" class="form-control" type="date" placeholder="startDate" id="startdate">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input name="enddate" class="form-control" type="date" placeholder="endDate" id="enddate">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-10 co-lg-8 mb-2 d-block ms-auto me-auto ">
                            <div class="form-group">
                                <div class="input-group">
                                    <input name="budget" class="form-control" type="number" placeholder="budget" id="budget">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input name="action" value="UpdateProject" type="submit" class="btn btn-success">
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    // When the modal is shown, update the hidden projectId input with the button's data-id
    const updateProjectModal = document.getElementById('UpdateProject');
    updateProjectModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; // Button that triggered the modal
        const projectId = button.getAttribute('data-id'); // Get the projectId from data-id
        const projectname = button.getAttribute('data-name');
        const projectdescription = button.getAttribute('data-description');
        const  projectstartdate = button.getAttribute('data-start-date');
        const projectenddate = button.getAttribute('data-end-date');
        const  data_budget = button.getAttribute('data-budget');


        // Find the hidden input in the modal and set its value to the projectId
        const modalProjectIdInput = document.getElementById('projectId');
        modalProjectIdInput.value = projectId;
        const name = document.getElementById('name');
        const description = document.getElementById('description');
        const startDate = document.getElementById('startdate');
        const enddate = document.getElementById('enddate');
        const budget = document.getElementById('budget');
        name.value = projectname;
        description.value = projectdescription;
        startDate.value = projectstartdate;
        enddate.value = projectenddate;
        budget.value = data_budget;



    });
</script>

