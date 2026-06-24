# YouTube Search App

This is a simple Android application developed as a university assignment. It uses the YouTube Data API v3 to search for videos and display the results in a custom list.

## Project Features
- Search for any YouTube video using a search bar.
- Displays video results in a `RecyclerView` (includes thumbnail, title, channel name, publish date, and description).
- Handles different error states:
  - Empty search input.
  - No results found.
  - Network failure / No internet connection.

## Libraries Used
- **Retrofit2 & Gson:** For API calls and parsing JSON.
- **Glide:** For image loading and caching.

## How to Run
1. Clone the repository.
2. Open the project in Android Studio.
3. Open `MainActivity.java` and replace the API key placeholder with your own YouTube API Key:
   `private static final String API_KEY = "YOUR_API_KEY_HERE";`
4. Run the app.

> Note: The video demonstration required for this assignment has been submitted via Google Drive.
