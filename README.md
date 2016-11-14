# WhiskeyCRUD

WhiskeyCRUD is Kyle Ennis' first attempt at building a web application. The purpose of the app is to create,
read, update, destroy, and sort different whiskeys according to taste and location. The technologies used
include Java, Spring, GoogleMaps API, html, and CSS. In the future I hope to clean up the controller with better
encapsulation, add Spring validation, and alter the update feature so that instead of replacing a whiskey bean's
fields it calculates an average of all updates for that whiskey. Most stumbling points came from relying on java
rather than using more applicable Spring practices, like recalling the DAO's get methods instead of using an
@SessionAttributes tag.
