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

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td {
            /*border: 1px solid #dddddd;*/
            text-align: left;
            /*padding: 8px;*/
        }

        th {
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
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
            <table>
                <tr>
                    <th><fmt:message key="input.string.carsFhoto"/>
                    </th>
                    <th><fmt:message key="input.string.carsCharacteristics"/>
                    </th>
                    <th><fmt:message key="input.string.driversFoto"/>
                    </th>
                    <th><fmt:message key="input.string.driversCharacterisrics"/>
                    </th>
                </tr>

                <c:forEach items="${requestScope.taxiObjects}" var="taxi">
                    <tr>
                        <td width="150px">
                            <img height="100px" width="150px" src="<c:url value="/static/${taxi.car.carNumber}.jpg"/>"/>
                        </td>
                        <td>
                            <ul>
                                <li>
                                    <fmt:message key="input.string.mark"/>&nbsp;
                                    <font color="red">${taxi.car.carBrand}&nbsp;${taxi.car.mark}</font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.price"/>&nbsp;
                                    <font color="red">${taxi.car.price}&nbsp;$</font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.carClass"/>&nbsp;
                                    <font color="red">${taxi.car.carClass}</font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.power"/>&nbsp;
                                    <font color="red">
                                            ${taxi.car.power}&nbsp;
                                        <fmt:message key="input.string.powerMeter"/>
                                    </font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.fuelConsumption"/>&nbsp;
                                    <font color="red">
                                            ${taxi.car.fuelConsumption}&nbsp;
                                        <fmt:message key="input.string.fuelConsumptionMeter"/>
                                    </font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.carNumber"/>&nbsp;
                                    <font color="red">${taxi.car.carNumber}</font>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <img height="100px" width="150px"
                                 src="<c:url value="/static/${taxi.driver.rightsNumber}.jpg"/>"/>
                        </td>
                        <td>
                            <ul>
                                <li>
                                    <fmt:message key="input.string.driverFIO"/>&nbsp;
                                    <font color="red">
                                            ${taxi.driver.name}&nbsp;${taxi.driver.surname}
                                    </font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.driverAge"/>&nbsp;
                                    <font color="red">
                                            ${taxi.driver.age}
                                    </font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.categoryRights"/>&nbsp;
                                    <font color="red">
                                        <c:forEach items="${taxi.driver.rights}" var="rights">
                                            ${rights}
                                        </c:forEach>
                                    </font>
                                </li>
                                <li>
                                    <fmt:message key="input.string.workExperience"/>&nbsp;
                                    <font color="red">
                                            ${taxi.driver.workExperience}
                                    </font>
                                </li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </div>

    <div>
        <p>
            <a href="${pageContext.request.contextPath}/taxi/changeLanguage?lan=ua">Укр.</a>&nbsp;
            <a href="${pageContext.request.contextPath}/taxi/changeLanguage?lan=en">Eng.</a>
        </p>
        <br>
        <fieldset>
            <legend>
                <strong>
                    <fmt:message key="input.string.sorting"/>
                </strong>
            </legend>

            <select onchange="window.location.href=this.options[this.selectedIndex].value">
                <option
                        <c:if test="${parametrSort eq 'input.string.price'}">
                            selected
                        </c:if>
                        VALUE="${pageContext.request.contextPath}/taxi/sortCarsByPrice"><fmt:message
                        key="input.string.price"/>
                </option>
                <option
                        <c:if test="${parametrSort eq 'input.string.carClass'}">
                            selected
                        </c:if>
                        VALUE="${pageContext.request.contextPath}/taxi/sortCarsByClass"><fmt:message
                        key="input.string.carClass"/>
                </option>
                <option
                        <c:if test="${parametrSort eq 'input.string.power'}">
                            selected
                        </c:if>
                        VALUE="${pageContext.request.contextPath}/taxi/sortCarsByPower"><fmt:message
                        key="input.string.power"/>
                </option>
                <option
                        <c:if test="${parametrSort eq 'input.string.fuelConsumption'}">O
                        selected
                </c:if>
                        VALUE="${pageContext.request.contextPath}/taxi/sortCarsByFuelConsumption"><fmt:message
                        key="input.string.fuelConsumption"/>
                </option>
            </select>
        </fieldset>
    </div>
</div>

</body>
</html>
