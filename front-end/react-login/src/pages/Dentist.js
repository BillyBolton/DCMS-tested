import React, {Component} from 'react'
import axios from "axios";
import {List} from "semantic-ui-react";

export default class Dentist extends Component {
    state = {
        persons: []
    }

    componentDidMount() {

        axios.get('http://localhost:8080/profile/findAll')
            .then(res => {
                const persons = res.data;
                this.setState({persons});
                console.log(this.state.persons)
            })
    }

    render() {
        return (
            <div className="Receptionist">
                <List>
                    {this.state.persons.map(person => <List.Item>{person.firstName}</List.Item>)}
                </List>
                <ul>
                    {
                        this.state.persons
                        .map(person => <li key = {person.id}>{person.firstName}</li>)
                    }
                </ul>
            </div>
        );
    }

}