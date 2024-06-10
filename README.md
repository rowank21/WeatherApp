Rowan Kyle Naidoo-ST10437470
The purpose of this app is to provide users with detailed and accurate weather information. 
The app includes a splash screen to welcome users, a main activity that displays a list of weather data items, and a detailed view activity that shows specific weather details for a selected item. 
The app aims to enhance the user experience by offering intuitive navigation, clear data presentation, and interactive features such as clickable items to view more information.
By providing timely and precise weather updates, this app helps users plan their activities and stay informed about current and upcoming weather conditions.

Features
Splash Screen: A welcoming screen that appears when the app is launched.
Main Activity: Displays a list of weather data items.
Detailed View Activity: Provides detailed weather information for a selected item.
Components
Splash Activity
Purpose: The splash screen welcomes users and sets the stage for the main functionality of the app.
Details:

Displays a welcoming screen for 3 seconds.
Transitions to the MainActivity after the delay.

Main Activity
Purpose: The main screen of the app that displays a list of weather data items.

Details:

Initializes the user interface elements.
Sets up a RecyclerView to display a list of items.
Handles item clicks to transition to the DetailedViewActivity with the selected item's data.

Detailed View Activity
Purpose: Provides detailed weather information for a selected item.

Details:

Retrieves data from the intent.
Initializes the user interface elements.
Displays the detailed weather information.

pseudocode: splash activity

Start
  Declarations
    val handler: Handler
    val intent: Intent
  
  Initialize UI elements
    Set content view to splash screen layout
  
  Delay Execution for 3 seconds
    handler.postDelayed
      Create Intent to transition to MainActivity
      Initialize intent with MainActivity class
      Start MainActivity
      Finish SplashScreenActivity
Stop

pseudocode: main activity
Start
  Declarations
    val items: List<Item>
    val adapter: Adapter
    val recyclerView: RecyclerView
  
  Initialize UI elements
    Set content view to main activity layout
    Find recyclerView by ID
  
  Set up RecyclerView
    Initialize items with data
    Initialize adapter with items
  
  Assign adapter to recyclerView
    recyclerView.setAdapter(adapter)
  
  Handle item click
    adapter.setOnItemClickListener
      Create Intent to transition to DetailedViewActivity
      Initialize intent with DetailedViewActivity class
      Put extra data (selected item) into Intent
      Start DetailedViewActivity
Stop

pseudocode: Deatails Activity
Start
  Declarations
    val selectedItem: Item
    val textView: TextView
  
  Retrieve data from Intent
    selectedItem = intent.getParcelableExtra("item")
  
  Initialize UI elements
    Set content view to detailed view layout
    Find textView by ID
  
  Set data to UI elements
    textView.setText(selectedItem.data)
Stop

link to github repo:https://github.com/rowank21/WeatherApp.git













