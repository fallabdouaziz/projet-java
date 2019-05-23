 <%@include file="../header.jsp"%>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Tables <small>Some examples to get you started</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
              <div class="clearfix"></div>

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Table design <small>Custom design</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">

                    <p>Add class <code>bulk_action</code> to table for bulk actions options on row select</p>

                    <div class="table-responsive">
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th>
                              <input type="checkbox" id="check-all" class="flat">
                            </th>
                            <th class="column-title">Identifiant </th>
                            <th class="column-title">Nom du Lieu</th>
                            <th class="column-title">Utilisateur </th>
                            <th class="column-title">Action </th>
                            <th class="column-title"><span class="nobr">Action</span>
                            </th>
                            <th class="bulk-actions" colspan="7">
                              <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                            </th>
                          </tr>
                        </thead>
						<c:forEach items="${listeLieu }" var="liste">			
						       <tbody>
                          <tr class="even pointer">
                            <td class="a-center ">
                              <input type="checkbox" class="flat" name="table_records">
                            </td>
                            <td class=" ">${liste.id }</td>
                            <td class=" ">${liste.nom }</td>
                            <td class=" ">${liste.user.prenom } <i class="success fa fa-long-arrow-up"></i></td>
                            <td class="a-right a-right "> <a href="lieu-update"><button type="button" class="btn btn-round btn-primary">Modifier</button></a></td>
                            <td class=" last"><a href="#"><button type="button" class="btn btn-round btn-danger">Supprimer</button></td></a>
                            </td>
                          </tr>
                        </tbody>
						</c:forEach>
                 
                      </table>
                     <a href="lieu-add" style="font-size: 20px;"><i class="fa fa-plus-square"></i> Ajouter un nouveau Lieu</a> 
                    </div>
							
						
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

         <%@include file="../footer.jsp"%>