
# react-native-location-change

React native library for getting _significant_ location changes from iOS (only).  An example is [here](https://github.com/npomfret/react-native-location-change-example).

Standard RN installation instructions below, but you also need to modify your `info.plist` file:

	<key>NSLocationWhenInUseUsageDescription</key>
    <string>This is needed to get location updates</string>
	<key>NSLocationAlwaysUsageDescription</key>
    <string>This is needed to get location updates in the background</string>

Add the dependency to your package.json (its not on npm yet)

    "react-native-location-change": "git@github.com:npomfret/react-native-location-change.git"
    
And your js code should do something like:
    
    import {AppRegistry, StyleSheet, Text, View, NativeModules, NativeEventEmitter} from "react-native";
    
    const _EVENT_EMITTER = new NativeEventEmitter(NativeModules.RNLocationChange);
    
    export default class LocationChangeExample extends Component {
      componentWillMount() {
        this.setState({location: null});
    
        _EVENT_EMITTER.addListener('significantLocationChange', (data) => {
          console.log("event:", data);
          this.setState({location: data});
        });
    
        NativeModules.RNLocationChange.start();
      }
    
      componentWillUnmount() {
        NativeModules.RNLocationChange.stop();
      }


## Getting started

`$ npm install react-native-location-change --save`

### Mostly automatic installation

`$ react-native link react-native-location-change`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-location-change` and add `RNLocationChange.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNLocationChange.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNLocationChangePackage;` to the imports at the top of the file
  - Add `new RNLocationChangePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-location-change'
  	project(':react-native-location-change').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-location-change/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-location-change')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNLocationChange.sln` in `node_modules/react-native-location-change/windows/RNLocationChange.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNLocationChange;` to the usings at the top of the file
  - Add `new RNLocationChangePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNLocationChange from 'react-native-location-change';

// TODO: What to do with the module?
RNLocationChange;
```
  