# AutoService Manager - App Overview

## Overview
This Android app manages clients and appointments. It contains screens for adding clients, listing appointments, viewing details, simple list tests, statistics and an about page. Emojis are used as visual status/priority markers.

## Screens
- `MainActivity` — launcher / home screen.
- `AddClientActivity` — form to add a new client (name, contact, optional emoji).
- `ListProgramariActivity` — list of appointments (filter/search).
- `DetaliiProgramareActivity` — appointment details, edit/delete actions.
- `TestListViewActivity` — experimental list view for testing UI.
- `StatisticsActivity` — basic stats and summaries.
- `AboutActivity` — app info.

## Buttons and Actions
- Add / New: opens `AddClientActivity` to create a client or appointment.
- Save: validates form fields and persists data to local storage/DB.
- Edit: switches details view into edit mode.
- Delete: removes the item (shows confirmation dialog).
- Back / Close: returns to the previous screen.
- Confirm / Cancel: used in dialogs for irreversible actions.

All button labels use clear verbs and show a short toast/snackbar on success/error.

## Emojis
- Emojis are used as simple visual tags (status, mood, priority).
- Stored as Unicode characters in the app database or model.
- Selection: a small emoji picker or dropdown next to the name field in `AddClientActivity`.
- Display: rendered inline with client/appointment text or as a badge in list items.

Design note: emojis are decorative; avoid relying on them for critical information alone.

## Permissions
- `POST_NOTIFICATIONS` is requested for Android 13+ to show local notifications. The app should request this permission at runtime before posting notifications.

## Build and Run (Windows)
- Open the project in Android Studio Otter.
- Or build from terminal in project root:
  - `.\gradlew assembleDebug`
- APK output: `app/build/outputs/apk/debug/app-debug.apk`
- Run on emulator or connected device from Android Studio or via `adb install`.

## Testing & Debugging
- Use Android Studio's debugger and Logcat.
- Unit/UI tests can be added under `app/src/test` and `app/src/androidTest`.

## Notes for Contributors
- Follow existing Kotlin/Java and Gradle structure.
- Keep `local.properties` and keystores out of version control.
- Use meaningful commit messages and push to `main` branch.
