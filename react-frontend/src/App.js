import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Col, Container, Row } from 'react-bootstrap';
import React from 'react';
import ModuleList from './components/ModuleList';
import Module from './components/Module';
import Bienvenue from './components/Bienvenue';
import Navigationbar from './components/Navigatiobar';

function App() {
  return (
    <Router>
      <Navigationbar />
      <Container>
        <Row>
          <Col lg={12} style={{ marginTop: '20px' }}>
            <Routes>
              <Route exact path="/" element={<Bienvenue />}></Route>
              <Route exact path="/add" element={<Module />}></Route>
              <Route exact path="/list" element={<ModuleList />}></Route>
            </Routes>
          </Col>
        </Row>
      </Container>
    </Router>
  );
}

export default App;
