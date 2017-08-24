# Pre-work - Todo_App

Simple Todo  is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Namrata Ojha

Time spent: 6 hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ] User can **successfully add and remove items** from the todo list
* [ ] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [ ] User can **persist todo items** and retrieve them properly on app restart

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://youtu.be/ppH1k8IDrGU' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://i.imgur.com/jDHoc5d.gifv).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** Android user interface is comparatively easy as it only require drag and drop, it also has xml file which you can use too. Coding part and interface are separate so makes the code readable. Most of the functionality of android can be accessed using Intent and in 2-3 lines.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:**  In android, An adapter is a bridge between UI component and data source that helps us to fill data in UI component. It holds the data and send the data to adapter view then view can takes the data from the adapter view and shows the data on different views like listview, gridview, spinner etc. ArrayAdapter is more simple and commonly used Adapter in android.
Whenever you have a list of single type of items which is backed by an array, you can use ArrayAdapter. For instance, list of phone contacts, countries or names or any integers.
ConvertView is used to reuse old view.
So if a list is of 15 items, but window can show only 5 items, then at first convertView would be null, and we need to create new views for these five items, but when you scroll down, you have two options, either create 6-10 views, or re-use old views and load new data into these views. Adapter and convertView enables you to do the later method.

## Notes

Describe any challenges encountered while building the app.

**Answer:** Updating the FileUtils was difficult, but later I got idea to use set method on items and update the adapter and then use ‘writeItems’ method to update FileUtils.

## License

    Copyright [2017] [Namrata Ojha]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
