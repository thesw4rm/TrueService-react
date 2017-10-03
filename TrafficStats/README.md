
# react-native-traffic-stats

## Getting started

`$ npm install react-native-traffic-stats --save`

### Mostly automatic installation

`$ react-native link react-native-traffic-stats`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-traffic-stats` and add `RNTrafficStats.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNTrafficStats.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNTrafficStatsPackage;` to the imports at the top of the file
  - Add `new RNTrafficStatsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-traffic-stats'
  	project(':react-native-traffic-stats').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-traffic-stats/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-traffic-stats')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNTrafficStats.sln` in `node_modules/react-native-traffic-stats/windows/RNTrafficStats.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Traffic.Stats.RNTrafficStats;` to the usings at the top of the file
  - Add `new RNTrafficStatsPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNTrafficStats from 'react-native-traffic-stats';

// TODO: What to do with the module?
RNTrafficStats;
```
  