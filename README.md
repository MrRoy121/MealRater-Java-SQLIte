# **Meal Rater**

## **Overview**

**Meal Rater** is an Android application that allows users to rate dishes from various restaurants. Users can add restaurant names, addresses, and meal details to an SQLite database and then rate each restaurant individually. This project is a great way to learn about database operations, custom dialogs, and rating bars in Android development.

## **Features**

- **Add Restaurant and Dish**: Users can input the name of the restaurant, address, and dish name.
- **Rate Meals**: Users can rate dishes using a customizable rating bar.
- **Save Ratings**: Ratings are saved in an SQLite database.
- **View Ratings**: Users can view a list of all rated meals.

## **Technical Details**

- **SQLite Database**: Stores restaurant names, addresses, dish names, and ratings.
- **Custom Dialog**: Used to input ratings.
- **RatingBar**: Allows users to rate dishes on a scale of 1 to 5 stars.
- **TextView and EditText**: Displays and captures input for restaurant and dish names.

## **How It Works**

1. **User Input**:
    - The user inputs the restaurant name, address, and dish name into `EditText` fields.
    - The user clicks the rate button to open a custom dialog for rating the dish.

2. **Rating Dialog**:
    - A custom dialog with a `RatingBar` is displayed.
    - The user sets a rating and clicks the set button to save the rating.
    - The rating is displayed in a `TextView` and saved to the SQLite database.

3. **Saving Ratings**:
    - The rating, along with the restaurant and dish details, is saved in the SQLite database.
    - A toast message confirms whether the data was successfully inserted.

4. **Viewing Ratings**:
    - Users can view all rated meals by clicking the show button, which navigates to a new activity displaying a list of all ratings.

## **Project Structure**

- **MainActivity**: Handles the main application logic, including user input, rating dialogs, and saving data to the database.
- **DBMealRaterHelper**: Manages database operations such as inserting and retrieving data.
- **MealRaterDataSource**: Defines the data model for storing restaurant and meal details.