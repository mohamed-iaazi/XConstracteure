<%--
  Created by IntelliJ IDEA.
  User: iaazi
  Date: 20/03/2025
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<div class="modal fade" id="UpdateTask" tabindex="-1" aria-labelledby="UpdateTaskModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="POST" action="${pageContext.request.contextPath}/ProjectDetail">
            <input type="hidden" name="TaskId" id="TaskId">
            <input type="hidden" name="projectId" id="projectId">
            <input type="hidden" name="action" value="UpdateTask">

            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="UpdateTaskModal">Update Task</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="card px-1 py-4">
                    <div class="card-body">
                        <h6 class="information mt-4">Please provide the following information</h6>
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

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input name="action" value="UpdateTask" type="submit" class="btn btn-success">
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    // When the modal is shown, update the hidden projectId input with the button's data-id
    const updateTaskModal = document.getElementById('UpdateTask');
    updateTaskModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; // Button that triggered the modal
        const TaskId = button.getAttribute('data-TaskId');
        const projectId = button.getAttribute('data-projectId');
        const descTask = button.getAttribute('data-descTache');
        const  startdate = button.getAttribute('data-startdate');
        const enddate = button.getAttribute('data-enddate');


        // Find the hidden input in the modal and set its value to the projectId
        const modalTaskIdInput = document.getElementById('TaskId');
        modalTaskIdInput.value = TaskId;

        const modalProjectId = document.getElementById('projectId');
        modalProjectId.value = projectId;

        const  modeldescription = document.getElementById('description');
        modeldescription.value = descTask;

        const  modelstartdate = document.getElementById('startdate');
        modelstartdate.value = startdate;

        const modelenddate = document.getElementById('enddate');
        modelenddate.value = enddate;
        




    });
</script>

