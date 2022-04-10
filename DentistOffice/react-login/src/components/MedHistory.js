import React, { Component } from 'react'
import { Segment } from 'semantic-ui-react'
import axios from "axios"

import MHAppointment from '../components/MHAppointment'

export default class MedHistory extends Component {

    state = {
        didUpdate: false,
        appointments: [],
        displayedAppt: {}
    }

    componentDidMount() {
        
        axios.get('http://localhost:8080/appointment/findByPatientId', { params: { id: (this.props.profile).id } })
            .then(app_res => {
                const app = app_res.data;
                console.log(app);
                this.setState({
                    appointments: app
                })
            })
    }

    componentDidUpdate() {
        if (this.props.profile != undefined && this.state.didUpdate == false) {
            this.componentDidMount()
            this.setState({didUpdate: true})
        }
    }

    render() {
        return (
            <>
            { this.state.appts !== [] && this.state.appts !== undefined ?

            this.state.appointments.map(appt => { return (
                <Segment key={appt.id}>
                    <MHAppointment appt={appt}/>
                </Segment>
            )

            })

            :
            
            <p>Patient has no medical history.</p>
            }
            </>
        )
    }
}