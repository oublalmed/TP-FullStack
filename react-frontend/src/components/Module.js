import { useEffect, useState } from 'react';
import { useNavigate, useParams, Link } from 'react-router-dom';
import { Container, Form, FormGroup, Label, Input, Button } from 'reactstrap';

function Module() {
  const initialForm = {
    nom: '',
    description: '',
  };

  const [module, setModule] = useState(initialForm);
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id !== 'new') {
      fetch(`/modules/${id}`)
        .then((resp) => resp.json())
        .then((data) => setModule(data));
    }
  }, [id, setModule]);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setModule({ ...module, [name]: value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    await fetch(`/modules${module.id ? `/${module.id}` : ''}`, {
      method: module.id ? 'PUT' : 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(module),
    });
    setModule(initialForm);
    navigate('/list');
  };

  const title = <h2>{module.id ? 'Edit Module' : 'Add Module'}</h2>;

  return (
    <div>
      <Container>
        {title}
        <Form onSubmit={handleSubmit}>
          <FormGroup>
            <Label for="nom">Nom</Label>
            <Input
              type="text"
              name="nom"
              id="nom"
              value={module.nom || ''}
              onChange={handleChange}
              autoComplete="nom"
            ></Input>
          </FormGroup>
          <FormGroup>
            <Label for="description">Description</Label>
            <Input
              type="text"
              name="description"
              id="description"
              value={module.description || ''}
              onChange={handleChange}
              autoComplete="description"
            ></Input>
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">
              Save
            </Button>
            <Button color="secondary" tag={Link} to="/list">
              Cancel
            </Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  );
}

export default Module;
