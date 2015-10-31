<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div>
	<h2>Warwick Analytics CSV Application</h2>
	 
	<sf:form method="POST" action="/WarwickAnalytics/processUploadedCSVFile"
		enctype="multipart/form-data">
		<fieldset>
			<table>
				<tr>
					<th><label for="csvUpload">Upload csv file:</label></th>
					<td><input name="csvUpload" type="file" />
				</tr>
				<tr>
					<th><input type="Submit" value="Submit" /></th>
					<td></td>
				</tr>
			</table>
		</fieldset>

		<!-- Maybe use a custom tag for this. -->
		<c:set var="columnHeaderList" value="${filteredCsvData.columnHeaderList}" />
		<fieldset>
			<table>
				<tr>
					<c:forEach items="${columnHeaderList}" var="resultHeader">
						<th>${resultHeader}</th>
					</c:forEach>
				</tr>
				<c:forEach items="${filteredCsvData.csvRows}" var="csvRow">
					<tr>
						<c:forEach items="${columnHeaderList}" var="columnHeader">
							<td>
							<c:choose>
							<%-- Use Unstandard taglib to get these two strings as constants. --%>
								<c:when test="${columnHeader == 'Decision'}">
       								${csvRow.decisionAsInt}
    							</c:when>
								<c:when test="${columnHeader == 'Id'}">
        							${csvRow.identifier}
    							</c:when>
								<c:otherwise>
							        ${csvRow.variables[columnHeader]}
							    </c:otherwise>
								</c:choose></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</sf:form>
</div>