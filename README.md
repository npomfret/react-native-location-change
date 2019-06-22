
# react-native-location-change

React native library for providing **low-power, background** geographic location changes.  

Not supported on Android yet.

On iOS it uses the _significant-change location service_ . It can supply location updates in the background without having to use the _Location Updates_ background mode [view [apple docs](https://developer.apple.com/library/content/documentation/UserExperience/Conceptual/LocationAwarenessPG/CoreLocation/CoreLocation.html)].

## Getting started

Add the dependency (its not on npm yet)

    npm install react-native-location-change@https://github.com/npomfret/react-native-location-change.git --save
    react-native link react-native-location-change


## iOS installation

Standard RN installation instructions for a native module are below, but you also need to modify your `info.plist` file:

iOS 11 and higher:
	<key>NSLocationAlwaysAndWhenInUseUsageDescription</key>
    <string>This is needed to get location updates</string>
	<key>NSLocationAlwaysUsageDescription</key>
    <string>This is needed to get location updates in the background</string>

Prior to iOS 11:
	<key>NSLocationAlwaysAndWhenInUseUsageDescription</key>
    <string>This is needed to get location updates</string>
	<key>NSLocationAlwaysUsageDescription</key>
    <string>This is needed to get location updates in the background</string>

If you'd like background updates, you may also need to add the following UI background modes to youy `info.plist` file:

	<key>UIBackgroundModes</key>
	<array>
		<string>fetch</string>
		<string>location</string>
	</array>
    
# Usage    

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

An working example is [here](https://github.com/npomfret/react-native-location-change-example).
