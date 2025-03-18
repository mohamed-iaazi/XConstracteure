<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resource List</title>

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
    <h2 class="text-center mb-4">Resources Details</h2>

    <!-- Table for larger screens -->
    <div class="table-responsive">
        <table class="table table-custom">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>type</th>
                    <th>quantité</th>
                    <th>fournisseur</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>bala</td>
                    <td>materail</td>
                    <td>10ps</td>
                    <td>Manpower</td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Card layout for mobile screens -->
    <div class="card-mobile">
        <div class="card border-dark-subtle p-3 mb-3">
            <div class="card-body">
                <p class="card-text"><strong>Name:</strong> bala</p>
                <p class="card-text"><strong>type:</strong>material</p>
                <p class="card-text"><strong>quantité:</strong> 10 ps</p>
                <p class="card-text"><strong>fournisseur:</strong>  Equipment</p>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="AjouterResource" tabindex="-1" aria-labelledby="AjouterResourceModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="POST" action="AjouterResource">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="AjouterResourceModal">Ajouter Resource</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="card px-1 py-4">
                <div class="card-body">

                    <div class="row mb-2">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input name="name" class="form-control" type="text" placeholder="name"></input>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input name="type" class="form-control" type="text" placeholder="type"></input>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row mb-2">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <input name="quantité" class="form-control" type="text" placeholder="quantité"></input>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Select with Bootstrap-Select -->
                    <div class="row mb-2">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <select class="selectpicker form-control">
                                    <optgroup label="fournisseur" data-max-options="2" >
                                        <option disabled selected>Choose One</option>
                                        <option>TSL</option>
                                        <option>PEb</option>
                                        <option>FSTR</option>
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
<button type="button" class="btn btn-success btn-lg rounded-circle position-fixed bottom-0 end-0 m-4 shadow-lg" data-bs-toggle="modal" data-bs-target="#AjouterResource">
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

        document.getElementById("AjouterTask").addEventListener("shown.bs.modal", function () {
            selectElements.forEach(function (select) {
                select.dispatchEvent(new Event("change"));
            });
        });
    });
</script>


</body>
</html>
