<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>
<body class="">
<header>
    <nav class="navbar navbar-dark bg-dark  navbar-expand-lg ">
        <div class="container-fluid ">
            <a class="navbar-brand " href="#">XConstracteur</a>
            <button class="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto me-auto ">

                    <li class="nav-item ps-3 pe-3  ">
                        <a class="nav-link " href="${pageContext.request.contextPath}/">Project</a>
                    </li>
                    <li class="nav-item ps-3 pe-3">
                        <a class="nav-link " href="${pageContext.request.contextPath}/Resources">Resources</a>
                    </li>

                </ul>
                <button class=" pe-3 logout  btn-secondary btn " href="logout">Logout</button>
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="container">
        <h3 class="text-center mt-4">Our Project</h3>

        <div class="row justify-content-center pt-5 gap-1">
            <c:forEach var="project" items="${projects}">
            <div class=" col-sm-12 col-md-5 col-lg-3 ">
                <div class="card">
                    <div class="card-header bg-dark text-light text-center">
                       ${project.name}
                    </div>
                    <div class="card-body">
                        <p class="text-center">${project.projectDescription}</p>
                    </div>
                    <p class="text-center">Start Date</p>
                    <div class="d-flex justify-content-center">
                        <div class="date-card bg-secondary text-white p-2 m-1 text-center">
                            <div class="date-number">02</div>
                            <div class="date-label">Day</div>
                        </div>
                        <div class="date-card bg-secondary text-white p-2 m-1 text-center">
                            <div class="date-number">02</div>
                            <div class="date-label">Month</div>
                        </div>
                        <div class="date-card bg-secondary text-white p-2 m-1 text-center">
                            <div class="date-number">2025</div>
                            <div class="date-label">Year</div>
                        </div>
                    </div>


                    <p class="text-center">End Date</p>
                    <div class="d-flex justify-content-center">
                        <div class="date-card bg-secondary-subtle text-secondary p-2 m-1 text-center">
                            <div class="date-number">02</div>
                            <div class="date-label">Day</div>
                        </div>
                        <div class="date-card bg-secondary-subtle text-secondary p-2 m-1 text-center">
                            <div class="date-number">02</div>
                            <div class="date-label">Month</div>
                        </div>
                        <div class="date-card bg-secondary-subtle text-secondary p-2 m-1 text-center">
                            <div class="date-number">2025</div>
                            <div class="date-label">Year</div>
                        </div>

                    </div>
                    <p class="text-center text-dark">budget : ${project.budget}</p>

                    <div class="card-footer justify-content-center d-flex ">
                        <button class="btn btn-success m-1" >
                            <a class="text-light " href="ProjectDetail">
                                <i class="fas fa-eye"></i>
                            </a>
                        </button>
                        <button class="btn btn-danger m-1" >
                            <a class="text-light " href="${pageContext.request.contextPath}/" >
                                <input name="action" value="SupprimerProject?id=${project.projectId}" type="hidden">
                                <i class="fas fa-trash"></i>
                            </a>
                        </button>

                        <button class="btn btn-info m-1"   >
                            <a class="text-light " href="${pageContext.request.contextPath}/">
                                <input name="action" value="UpdateProject?id=${project.projectId}" type="hidden">
                                <i class="fas fa-edit"></i>
                            </a>
                        </button>
                    </div>
                </div>
            </div>
            </c:forEach>
            <div class="col-sm-12 col-md-5 col-lg-3">

            </div>
            <div class="col-sm-12 col-md-5 col-lg-3">


            </div>
        </div>

    </div>
</main>



<!-- Modal -->
<div class="modal fade" id="AjouterProject" tabindex="-1" aria-labelledby="AjouterProjectModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="POST" action="${pageContext.request.contextPath}/">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="AjouterProjectModal">Ajouter Project</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="card px-1 py-4">
                    <div class="card-body">
                        <h6 class="information mt-4">Please provide the following information</h6>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <input name="name" class="form-control" type="text" placeholder="Name">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <div class="input-group">
                                        <textarea name="description" class="form-control" type="text" placeholder="description"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input name="startdate" class="form-control" type="date" placeholder="startDate">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 mb-2">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input name="enddate" class="form-control" type="date" placeholder="endDate">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-10 co-lg-8 mb-2 d-block ms-auto me-auto ">
                            <div class="form-group">
                                <div class="input-group">
                                        <input name="budget" class="form-control" type="number" placeholder="budget"></input>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input name="action" value="AjouterProject" type="submit" class="btn btn-success" >
                </div>
            </div>
        </form>
    </div>
</div><!-- Floating Add Button -->
<button type="button" class="btn btn-success btn-lg rounded-circle position-fixed bottom-0 end-0 m-4 shadow-lg" data-bs-toggle="modal" data-bs-target="#AjouterProject">
    <i class="fas fa-plus"></i>
</button>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>