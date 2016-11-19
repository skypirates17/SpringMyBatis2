<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<link rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
		<title>Spring MyBatis 2</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#example').DataTable( {
		    	// add 'move to first' and 'move to last' options/buttons in pagination
		    	"pagingType": "full_numbers",
		    	
		    	// remove search field
		    	"searching": true,
		    	
		    	// modify the value of length dropdown
		    	"lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		    	
		    	// change the label length menu
		    	"language": {
		    		"lengthMenu" : "Display _MENU_ records per page",
		    	}
		    });
		    
		    //enable selection highlight
		    var table = $('#example').DataTable();
		    $('#example tbody').on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
		            $(this).removeClass('selected');
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		        }
		    } );
		    
		    /* 
		    * Since the main table is displayed none, we'll be using this line of code to show the table.
		    * this is to prevent the table from showing while data is being loaded
		    *
		    * Alternative: instead of adding style="display:none" in each tables, 
		    * we will modify the css of DataTable, and add the above style to class of the table
		    */
		    $('#example').fadeIn(300);
		} );
	</script>
	<body>
		<div class="container">
			<form method="post" action="Registration.htm" name="RegisterForm" class="form-horizontal">
				<h4>Registration Form</h4>
				<div class="form-group">
					<label class="col-sm-2 control-label">Student Name :</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="STUDENT_NAME" name="STUDENT_NAME" placeholder="Name" maxlength="100" required="required"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Student Age : </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="STUDENT_AGE" name="STUDENT_AGE" placeholder="Age" maxlength="3" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Student Address : </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="STUDENT_ADDRESS" name="STUDENT_ADDRESS" placeholder="Address"  maxlength="255" required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="Submit" name="Save" value="Save" class="btn btn-primary btn-sm" />
						<input type="Reset" name="Clear" value="Clear" class="btn btn-default btn-sm" />
					</div>
				</div>
			</form>
			<c:if test="${!empty recordsList}">
				<table id="example" class="display" cellspacing="0" width="100%" style="display:none">
					<thead>
						<tr>
							<th>Student ID</th>
							<th>Student Name</th>
							<th>Student Age</th>
							<th>Student Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${recordsList}" varStatus="status">
							<tr>
								<td>
									<a href="#">
										<c:out value="${item.student_id}" />
									</a>
								</td>
								<td>
									<c:out value="${item.student_name}" />
								</td>
								<td>
									<c:out value="${item.student_age}" />
								</td>
								<td>
									<c:out value="${item.student_address}" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</body>
</html>