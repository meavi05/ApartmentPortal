# ApartmentPortal
SpringBoot Apartment Portal

This is a SpringBoot project working as a back-end to React application. 
This application exposes REST request mapping
1) POST : /addUser @RequestBody User
2) POST : /authorizeUser @RequestBody User
3) GET : /getUserData/{email}
4) POST : /addApartment @RequestBody Apartment
5) POST : /addTenant @RequestBody Tenant
6) GET : /getTenantsData/{email}
7) DELETE : /deleteTenant/{email}

