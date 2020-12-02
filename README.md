# ApartmentPortal
SpringBoot Apartment Portal

This is a SpringBoot project working as a back-end to React application. ApartmentPortal is for the apartment owner in which they can add and maintains their apartments details & tenants information.

An apartment owner can add their apartment and manages with the functionalities which in background based on REST calls.
This application exposes REST request mapping
1) POST : /addUser @RequestBody User
2) POST : /authorizeUser @RequestBody User
3) GET : /getUserData/{email}
4) POST : /addApartment @RequestBody Apartment
5) POST : /addTenant @RequestBody Tenant
6) GET : /getTenantsData/{email}
7) DELETE : /deleteTenant/{email}


Apartment Portal is still in build phase. The goal of this application is to handle all the requests from React API calls, persist the data and provide a JSON response to React method for further processing.

