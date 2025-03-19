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
    <h2 class="text-center mb-4">Project Details</h2>

    <!-- Table for larger screens -->
    <div class="table-responsive">
        <table class="table table-custom">
            <thead>
                <tr>
                    <th>Task</th>
                    <th>Description</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>budget</th>
                    <th>Resources</th>

                </tr>
            </thead>
            <tbody>

                <tr>
                    <td>${project.name}</td>
                    <td>${project.projectDescription}</td>
                    <td>${project.startDate}</td>
                    <td>${project.endDate}</td>
                    <td>${project.budget}</td>
                    <td>Man</td>

                </tr>

            </tbody>
        </table>
    </div>

    <!-- Card layout for mobile screens -->
    <div class="card-mobile">
        <div class="card border-dark-subtle p-3 mb-3">
            <div class="card-body">
                <h5 class="card-title text-center">${project.name}</h5>
                <p class="card-text"><strong>Description:</strong> ${project.projectDescription}</p>
                <p class="card-text"><strong>Start Date:</strong> ${project.startDate}</p>
                <p class="card-text"><strong>End Date:</strong> ${project.endDate}</p>
                <p class="card-text"><strong>budget:</strong> ${project.budget}</p>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="AjouterTask" tabindex="-1" aria-labelledby="AjouterTaskModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="POST" action="AjouterTask">
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
                                <div class="input-group">
                                    <textarea name="description" class="form-control" type="text" placeholder="Description"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p class="mt-1 text-secondary mb-1">start Date</p>

                    <div class="row mb-2">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input name="startDate" class="form-control" type="date" placeholder="Start Date">
                                </div>
                            </div>
                        </div>
                    </div>
                    <p class="mt-1 text-secondary mb-1">end Date</p>

                    <div class="row mb-2">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input name="endDate" class="form-control" type="date" placeholder="End Date">
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Select with Bootstrap-Select -->
                    <div class="row mb-2">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <select class="selectpicker form-control" multiple data-live-search="true" data-actions-box="true">
                                    <optgroup label="Resources" data-max-options="2">
                                        <option>Bala</option>
                                        <option>Man</option>
                                        <option>Cars</option>
                                    </optgroup>
                                </select>
                            </div>
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
