<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${localeLang}"/>
<fmt:setBundle basename="mess"/>

<html>
<head>
    <title>
        <fmt:message key="input.string.title"/>
    </title>
    <style>
        .menu {
            display: flex;
            flex-flow: row wrap;
            justify-content: space-between;
        }
    </style>
</head>
<body>
<div class="menu">
    <div>
        <p>
            <a href="${pageContext.request.contextPath}/taxi/welcomePage"><fmt:message key="input.string.main"/></a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/taxi/initialException"><fmt:message
                    key="input.string.exception"/></a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/taxi/showCars"><fmt:message key="input.string.cars"/></a>
        </p>
    </div>

    <div>
        <fieldset>
            <legend><strong><img height="30%" width="100%" src="<c:url value="/static/logo.png"/>"/></strong></legend>
            <fieldset>

                <fieldset>
                    <legend>
                        <strong>
                            <fmt:message key="input.string.taxiParkPrice"/>
                        </strong>
                    </legend>
                    ${taxiParkPrice}&nbsp;$
                </fieldset>

                <fieldset>
                    <legend>
                        <strong>
                            <fmt:message key="input.string.numberOfCars"/>
                        </strong>
                    </legend>
                    ${numberOfCars}
                </fieldset>

            </fieldset>
        </fieldset>
    </div>

    <div>
        <p>
            <a href="${pageContext.request.contextPath}/taxi/changeLanguage?lan=ua">Укр.</a>&nbsp;
            <a href="${pageContext.request.contextPath}/taxi/changeLanguage?lan=en">Eng.</a>
        </p>
    </div>
</div>

</body>
</html>
