# TestInstaleap

This test aims to display a list of movies and series with a filter, which is done successfully.

The architecture is made with MVVM in which there are 3 classes, one that is the view in which with some observers (observer pattern) it is possible to update the view, the second view is the View Model which calls the Repository class that is the one that calls the service and returns the information to the View Model and then to the observer to go to the view.

Hilt dependency injection (singleton pattern) and retrofit for the consumption of services are implemented.
