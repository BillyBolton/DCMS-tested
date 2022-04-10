import React, { Component } from 'react'
import { Button, Header, Form, Segment, Input } from 'semantic-ui-react'
import axios from "axios"

import DentistTabs from '../components/DentistTabs'
import DentistSchedule from '../components/DentistSchedule'

export default class Dentist extends Component {
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

        axios.get('http://localhost:8080/patient/existsByID', { params: {id: this.state.userId} })
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
            <><div className="Patient">
                <h1>Patient Look Up</h1>
                {this.state.valid ?
                    <DentistTabs loggedInUser={this.state.loggedInUser} />
                    :
                    <Segment raised compact padded='very'>
                        <Header as='h3'>Please enter Patient ID</Header>
                        <Form>
                            <Form.Field inline>
                                <Input placeholder='P_X' onChange={(e) => this.setState({ userId: e.target.value.trim() })} />
                                <Button content='enter' onClick={this.handleSubmit} />
                            </Form.Field>
                        </Form>
                    </Segment>}

            </div><br></br><br></br><div>
            <h1>Dentist Look Up</h1>
                <Segment raised>
                    <DentistSchedule />
                </Segment>

                </div></>
        )
    }
    
}