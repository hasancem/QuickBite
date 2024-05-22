
# QuickBite

QuickBite is a demo Android application designed to showcase an online food ordering system. The app demonstrates the use of web services to fetch data and features a listing screen to display available food items. The app leverages Retrofit for network requests and Glide for image loading.

## Technologies Used

- **Kotlin**: The primary programming language used for Android development.
- **View Binding**: Used for easier and safer access to views.
- **Fragments**: Modular sections of the UI.
- **Navigation Components**: Handles navigation between different parts of the app.
- **RecyclerView**: Used for displaying lists of food items.
- **Retrofit**: A type-safe HTTP client for making network requests.
- **Glide**: An image loading and caching library for Android.

## Project Structure

- **MainActivity.kt**: The main entry point of the application, handling the UI for the listing screen.
- **Fragments**: Handles different sections of the app.
- **Adapters**: Contains adapters for displaying data in RecyclerViews.
- **Retfrofit**: Client code for consuming web services
- **Data**: Data classes representing the structure of the data fetched from web services.

## Web Services (API)

The app uses the following web services to interact with the backend:

- **Get All Foods**: `http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php`
- **Get Food Images**: `http://kasimadalan.pe.hu/yemekler/resimler/{image_name}.png`
