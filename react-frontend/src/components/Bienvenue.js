import React from 'react';
import image from './../images/SIMO1.jpg';


const Bienvenue = () => {
  return (
    <center>
    <div className="jumbotron bg-dark text-white ">
      <div className='row'>
      <div className='col-6 col-md-4'>
    <img src={image} alt='Photo de profil' className='image' style={{width: 200, height: 200, borderRadius: 200/2}} /><br/><br/>
    </div>
    <div className='col-12 col-md-8 '>
       <h1>Bonjour</h1>
      <h1>OUBLAL Mohamed</h1>
      <blockquote className="blockquote mb-0">
        <p>Eléve-ingénieur en 3A-IWIM</p>
        <footer className="blockquote-footer">Mini projet : FullStack : react/SpringBoot </footer>
      </blockquote>
      </div>
      </div>
    </div>
    </center>
  );
};

export default Bienvenue;
