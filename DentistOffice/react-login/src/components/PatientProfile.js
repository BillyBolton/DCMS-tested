import React, { Component } from 'react'
import { Container, Button, Grid, List } from 'semantic-ui-react'
import axios from "axios"

import PatientModifyProfileForm from './PatientModifyProfileForm'


export default class PatientProfile extends Component {

    state = {
        didUpdate: false,
        id: "",
        email: "",
        firstName: "",
        middleName: "",
        lastName: "",
        addressId: "",
        buildingNumber: "",
        street: "",
        city: "",
        province: "",
        postalcode: "",
        dob: "",
        mode: "view",
        fullProfile: this.props.profile
    }

    handleModeChange() {

        if (this.state.mode == 'view') {
            this.setState({ ...this.state, mode: 'modify' })
        } else if (this.state.mode == 'modify') {

            axios.get('http://localhost:8080/patient/find/byId', { params: { id: this.state.id } })
                .then(user => {
                    const u = user.data
                    this.setState({
                        ...this.state,
                        email: u.email,
                        firstName: u.profile.firstName,
                        middleName: u.profile.middleName,
                        lastName: u.profile.lastName,
                        buildingNumber: u.profile.address.buildingNumber,
                        street: u.profile.address.street,
                        city: u.profile.address.city,
                        province: u.profile.address.province,
                        postalcode: u.profile.address.postalCode,
                        dob: u.profile.dob,
                        mode: 'view',
                        fullProfile: user.data
                    })

                })
        }
    }

    componentDidMount() {

        try {
            this.setState({
                id: (this.props.profile).id,
                email: (this.props.profile).email,
                firstName: (this.props.profile).profile.firstName,
                middleName: (this.props.profile).profile.middleName,
                lastName: (this.props.profile).profile.lastName,
                buildingNumber: (this.props.profile).profile.address.buildingNumber,
                street: (this.props.profile).profile.address.street,
                city: (this.props.profile).profile.address.city,
                province: (this.props.profile).profile.address.province,
                postalcode: (this.props.profile).profile.address.postalCode,
                dob: (this.props.profile).profile.dob
            })

            console.log(this.state)
        } catch {
            console.log("waiting on props")
        }
    }

    componentDidUpdate() {

        if (this.props.profile != undefined && this.state.didUpdate == false) {
            this.componentDidMount()
            this.setState({ didUpdate: true })
        }
    }

    render() {

        return (

            <>
                <Container>

                    {this.state.mode === "view" ?
                        <Grid columns={2}>
                            <Grid.Column width={5} float='right'>
                                <List>
                                    <List.Item header='ID' description={(this.state).id} />
                                    <List.Item header='First Name' description={(this.state).firstName} />
                                    <List.Item header='Middle Name' description={(this.state).middleName} />
                                    <List.Item header='Last Name' description={(this.state).lastName} />
                                </List>

                            </Grid.Column>
                            <Grid.Column>
                                <List>
                                    <List.Item header='Date of Birth' description={(this.state).dob} />
                                    <List.Item header='Address' description={(this.state).buildingNumber + " " + (this.state).street + ", " + (this.state).city + " (" + (this.state).province + ")"} />
                                    <List.Item header='Postal Code' description={(this.state).postalcode} />
                                    <List.Item header='Email' description={(this.state).email} />
                                </List>
                            </Grid.Column>

                        </Grid>

                        :

                        <PatientModifyProfileForm currProfile={this.state.fullProfile} />
                    }

                </Container>

                <br></br>

                {this.state.mode === 'view' ?
                    <Button onClick={() => this.handleModeChange()}>Modify profile</Button>
                    :
                    <Button onClick={() => this.handleModeChange()}>Return to profile</Button>
                }
            </>
        )

    }
}