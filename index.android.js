/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    NativeModules,
    Button
} from 'react-native';

export default class TrueService extends Component {
    render() {
        NativeModules.RNTrafficStats.startService(
            (data) => {
                this.bytes = data.toString();
                console.log(this.bytes)
            },
            (msg) => {
                console.log(msg)
            }
        );
        let stopService = function () {
            NativeModules.RNTrafficStats.stopService(
                (data) => {
                    this.bytes = data.toString();
                    console.log(this.bytes)
                },
                (msg) => {
                    console.log(msg)
                }
            );
        };
        return (
            <View style={styles.container}>
                <Text style={styles.welcome}>
                    Welcome to React Native!
                </Text>
                <Text style={styles.instructions}>
                    To get started, edit index.android.js
                </Text>
                <Text style={styles.instructions}>
                    Double tap R on your keyboard to reload,{'\n'}
                    Shake or press menu button for dev menu
                </Text>
                <Button
                    onPress={stopService}
                    title="Stop Service"
                    color="#841584"
                    accessibilityLabel="Stop the TrafficStats service"
                />
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});

AppRegistry.registerComponent('TrueService', () => TrueService);
