<%--
  Created by IntelliJ IDEA.
  User: iaazi
  Date: 21/03/2025
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>

<!-- Modal -->
<div class="modal fade" id="UpdateResource" tabindex="-1" aria-labelledby="UpdateResourceModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="post" action="Resources">
            <div class="modal-content">
                <div class="modal-header">

                    <h5 class="modal-title" id="UpdateResourceModal">Update  Resource</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="card px-1 py-4">
                    <div class="card-body">

                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input id="name" name="name" class="form-control" type="text" placeholder="name">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <textarea id="detail" name="detail" class="form-control"  placeholder="Resource Detail "></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input id="type" name="type" class="form-control" type="text" placeholder="type"></input>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <div class="input-group">
                                        <input id="quantité" name="quantite" class="form-control" type="number" placeholder="quantité"></input>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- Select with Bootstrap-Select -->
                        <div class="row mb-2">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label> <span class="text-secon">Fournisseur</span>
                                        <select id="fournisseur" name="fournisseur" class="selectpicker form-control">
                                            <option>TSL</option>
                                            <option>PEb</option>
                                            <option>FSTR</option>
                                        </select>
                                    </label>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="resourceId" id="id" >
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input name="action"  type="submit" class="btn btn-success" value="UpdateResource">
                </div>
            </div>
        </form>
    </div>
</div>


<script>
     const  UpdateResourceModal = document.getElementById('UpdateResource');
     UpdateResourceModal.addEventListener('show.bs.modal',  function (event){
            console.log(event);

            const  btn = event.relatedTarget;
            const id =document.getElementById("id");
            const  name = document.getElementById('name');
            const detail = document.getElementById('detail');
            const type = document.getElementById('type');
            const quantity = document.getElementById('quantité');
            const fournisseur = document.getElementById('fournisseur');

             const  idModel=btn.getAttribute('data-resourceId');
            const  nameModel =btn.getAttribute('data-name');
            const detailModel =btn.getAttribute('data-detail');
            const typeModel =btn.getAttribute('data-type');
            const quantityModel =btn.getAttribute('data-quantity');
            const fournisseurModel =btn.getAttribute('data-fournisseur');
             console.log(btn.getAttribute('data-quantity'))
             id.value = idModel;
            name.value = nameModel;
            detail.value = detailModel;
            quantity.value = quantityModel;
            fournisseur.value = fournisseurModel;
            type.value = typeModel;

            console.log( fournisseurModel)





     });


</script>