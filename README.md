# Unit-Converter
A simple android app for unit conversion.

The app contains a MainActivity class that is used a main page and navigation. Buttons leading to different activities are present in the MainActivity. A profile image on the toolbar takes the user to either ProfileActivity or LoginActivity depending on login status.

Sign In: Login using Google Sign In. Upon log in, redirect to MainActivity.

My Profile: Displays basic information about the user(profile image and name).

Categories: Distance, Area, Weight, Temperature, Speed, Information Units
Every activity works in a similar way: A simple card view containing 2 input fields accepting numeric values. The 2 spinners are used to choose units to convert. The convert button writes the result in the second input field. When pressed, the back button returns the user to the MainActivity.

Methods in every category:
populateSpinners() - gets values from a string array.
