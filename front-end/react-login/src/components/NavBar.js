import React, {Component} from 'react'
import {Menu} from "semantic-ui-react";

export default class NavBar extends Component {
    state = {};

    handleItemClick = (e, { name }) => {
        this.setState({ activeItem: name })
    }

    render() {
        const { activeItem } = this.state


    return (
        <Menu>
            <Menu.Item
                header
                href='/'
            > Struck By Whitening
            </Menu.Item>
            <Menu.Item
                name='editorials'
                active={activeItem === 'editorials'}
                onClick={this.handleItemClick} href='/dentist'
            >
                Dentist
            </Menu.Item>

            <Menu.Item
                name='reviews'
                active={activeItem === 'reviews'}
                onClick={this.handleItemClick} href='/receptionist'
            >
                Receptionist
            </Menu.Item>
            <Menu.Item
                name='upcomingEvents'
                active={activeItem === 'upcomingEvents'}
                onClick={this.handleItemClick} href='/patient'
            >
                Patient
            </Menu.Item>

            <Menu.Item
                name='upcomingEvents'
                active={activeItem === 'upcomingEvents'}
                onClick={this.handleItemClick} href='/branch'
            >
                Branch
            </Menu.Item>
        </Menu>
    );
    }
}