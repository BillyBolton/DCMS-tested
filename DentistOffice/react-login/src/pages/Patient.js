import React, { Component } from 'react'
import { Button, Header, Form, Segment, Input } from 'semantic-ui-react'
import axios from "axios"

import PatientTabs from '../components/PatientTabs'

export default class Patient extends Component {
    constructor(props) {
        super(props)

        this.state = {
            valid: false,
            userId: '',
            loggedInUser: {}
        }

        this.handleSubmit=this.handleSubmit.bind(this);
    }

    handleSubmit() {

        axios.get('http://localhost:8080/patient/existsById', { params: {id: this.state.userId} })
            .then( res => {
                if (res.data) {
                    axios.get('http://localhost:8080/patient/findByID', { params: {id: this.state.userId} })
                    .then(user => {
                    this.setState({
                        valid: res.data,
                        loggedInUser: user.data
                    })
                    console.log(this.state)
                })
                }
            })
    }

    render() {
        return (
            <div className="Patient">
                {this.state.valid ?
                <PatientTabs loggedInUser={this.state.loggedInUser}/>
                :
                <Segment raised compact padded='very'>
                    <Header as='h3'>Please enter your ID</Header>
                    <Form>
                        <Form.Field inline>
                            <label>P_</label>
                            <Input placeholder='#' onChange={(e) => this.setState({ userId: "P_"+e.target.value.trim() })}/>
                            <Button content='enter' onClick={this.handleSubmit}/>
                        </Form.Field>
                    </Form>
                </Segment>
                }
                
            </div>
        )
    }
    
}