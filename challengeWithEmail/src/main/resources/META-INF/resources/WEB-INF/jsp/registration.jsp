<%@ include file="common/header.jspf"%>
  
  
    <title>Registration Form</title>
    
<%@ include file="common/formValidator.jspf"%>

<title>Registration Form</title>   

<%@ include file="common/navigation.jspf"%>
<div class="container">
    <h2>Customer Registration</h2>
    <form:form action="/registration" method="post" modelAttribute="customer" id="registrationForm">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" class="form-control" value="${fn:escapeXml(customer.title)}"/>
            <form:errors path="title" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <label for="firstName">First Name</label>
            <form:input path="firstName" id="firstName" class="form-control" value="${fn:escapeXml(customer.firstName)}"/>
            <form:errors path="firstName" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <label for="lastName">Last Name</label>
            <form:input path="lastName" id="lastName" class="form-control" value="${fn:escapeXml(customer.lastName)}"/>
            <form:errors path="lastName" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <c:if test="${not empty emailError}">
                <div class="error">${emailError}</div>
            </c:if>
            <label for="emailAddress">Email Address</label>
            <form:input path="emailAddress" id="emailAddress" class="form-control" value="${fn:escapeXml(customer.emailAddress)}"/>
            <form:errors path="emailAddress" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <label for="addressLine1">Address Line 1</label>
            <form:input path="addressLine1" id="addressLine1" class="form-control" value="${fn:escapeXml(customer.addressLine1)}"/>
            <form:errors path="addressLine1" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <label for="addressLine2">Address Line 2</label>
            <form:input path="addressLine2" id="addressLine2" class="form-control" value="${fn:escapeXml(customer.addressLine2)}"/>
            <form:errors path="addressLine2" cssClass="text-danger" />
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="city" id="city" class="form-control" value="${fn:escapeXml(customer.city)}"/>
<form:errors path="city" cssClass="text-danger" />
</div>
    <div class="form-group">
        <label for="postcode">Postcode</label>
        <form:input path="postcode" id="postcode" class="form-control" value="${fn:escapeXml(customer.postcode)}"/>
        <form:errors path="postcode" cssClass="text-danger" />
    </div>
    
    <div class="form-group">
        <label for="phoneNumber">Phone Number</label>
        <form:input path="phoneNumber" id="phoneNumber" class="form-control" value="${fn:escapeXml(customer.phoneNumber)}"/>
        <form:errors path="phoneNumber" cssClass="text-danger" />
    </div>
    
    <form:hidden path="registered" value="${customer.registered}" />
<br>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
</body>

<%@ include file="common/footer.jspf"%>
