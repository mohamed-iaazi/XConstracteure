<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Title</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    
    <!-- Bootstrap-Select CSS (Updated Version) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">
</head>
<body>
    <header class="mb-5 " style="z-index:999; overflow: hidden;  ">
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark p-2 ">
            <div class="container-fluid p-2">
                <a href="${pageContext.request.contextPath}/" style="text-decoration: none;">
                    <button  style="border: none; background: none; cursor: pointer; font-size: 16px; color: rgb(255, 254, 254)">
                    <i class="fas fa-arrow-left"></i> Back
                </button>
    
                </a>
    
            </div>
        </nav>
    </header>

<!-- Table Section -->
<div class="container pt-5">
    <h2 class="text-center mb-4">Project Id : ${project}</h2>

    <!-- Table for larger screens -->
    <div class="table-responsive">
        <table class="table table-custom">
            <thead>
                <tr>
                    <th>Task Description</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Resources</th>
                    <th>Action</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>


            <c:forEach var="tache" items="${taches}">
                <tr>
                    <td>${tache.descTache}</td>
                    <td>${tache.startdateTache}</td>
                    <td>${tache.enddateTache}</td>
                    <td>null</td>
                    <!-- Delete Button -->
                   <td >
                       <form method="post" action="${pageContext.request.contextPath}/ProjectDetail">
                        <input type="hidden" name="action" value="SupprimerTask">
                        <input type="hidden" name="id" value="${tache.idTache}">
                           <input type="hidden" name="projectId" value="${project}">

                           <button type="submit" class="btn btn-danger ">
                            <i class="fas fa-trash"></i>
                        </button>
                    </form>
                   </td>


                   <td>
                    <!-- Update Button -->
                    <button type="button" class="btn btn-info " data-bs-toggle="modal" data-bs-target="#UpdateProject"
                            data-id="${project}">
                        <a class="text-light">
                            <i class="fas fa-edit"></i>
                        </a>
                    </button>
                    </td>

                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>


<c:forEach var="tache" items="${taches}">
    <div class="ms-5 ps-5 ">
    <!-- Card layout for mobile screens -->
<div class="card-mobile w-100 ">
    <div class="card border-dark-subtle p-3 mb-3  w-75">
            <div class="card-body">
                <h5 class="card-title text-center mb-1 fw-bold">${project}</h5>
                <p class="card-text"><strong>Description:</strong> ${tache.descTache}</p>
                <p class="card-text"><strong>Start Date:</strong> ${tache.startdateTache}</p>
                <p class="card-text"><strong>End Date:</strong> ${tache.enddateTache}</p>
                <p class="card-text"><strong>Resources:</strong> null</p>
                <!-- Delete Button -->
                <form method="post" action="${pageContext.request.contextPath}/ProjectDetail">
                    <input type="hidden" name="action" value="SupprimerTask">
                    <input type="hidden" name="id" value="${tache.idTache}">
                    <input type="hidden" name="projectId" value="${project}">
                    <button type="submit" class="btn btn-danger d-block ms-auto me-auto">
                        <i class="fas fa-trash"></i>
                    </button>
                </form>
                <!-- Update Button -->
                <button  type="button" class="btn btn-info d-block ms-auto me-auto mt-2" data-bs-toggle="modal" data-bs-target="#UpdateProject"
                        data-id="${project}">
                    <a class="text-light">
                        <i class="fas fa-edit"></i>
                    </a>
                </button>
            </div>
        </div>
    </div>
</div>
    </c:forEach>
</div>


    <!-- Modal -->
<div class="modal fade" id="AjouterTask" tabindex="-1" aria-labelledby="AjouterTaskModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <!-- Inside the modal -->
        <form method="POST" action="${pageContext.request.contextPath}/ProjectDetail">
            <input name="action" type="hidden" value="AjouterTask">
            <input type="hidden" name="projectId" value="${project}"> <!-- Pass projectId from servlet -->
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="AjouterTaskModal">Ajouter Task</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="card px-1 py-4">
                    <div class="card-body">
                        <h6 class="information mt-4 text-secondary mb-3 text-center">Please provide the following information</h6>

                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <textarea name="description" class="form-control" placeholder="Description"></textarea>
                                </div>
                            </div>
                        </div>

                        <p class="mt-1 text-secondary mb-1">Start Date</p>
                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <input name="startDate" class="form-control" type="date" placeholder="Start Date">
                            </div>
                        </div>

                        <p class="mt-1 text-secondary mb-1">End Date</p>
                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <input name="endDate" class="form-control" type="date" placeholder="End Date">
                            </div>
                        </div>

                        <!-- Select with Bootstrap-Select -->
                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <select name="resources" class="selectpicker form-control" multiple data-live-search="true" data-actions-box="true">
                                    <optgroup label="Resources">
                                        <option>Bala</option>
                                        <option>Man</option>
                                        <option>Cars</option>
                                    </optgroup>
                                </select>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </div>
        </form>

    </div>
</div>

<!-- Floating Add Button -->
<button type="button" class="btn btn-success btn-lg rounded-circle position-fixed bottom-0 end-0 m-4 shadow-lg" data-bs-toggle="modal" data-bs-target="#AjouterTask">
    <i class="fas fa-plus"></i>
</button>

<!-- jQuery (Must be loaded before Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bootstrap Bundle (JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Bootstrap-Select JS (Updated Version) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>

<!-- Initialize Bootstrap-Select (Vanilla JS) -->
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var selectElements = document.querySelectorAll(".selectpicker");
        
        selectElements.forEach(function (select) {
            new bootstrap.Select(select);
        });


    });
</script>


</body>
</html>
