import img1 from "../../assets/images/vegetables1.jpg";
import img2 from "../../assets/images/vegetables2.png";
import img3 from "../../assets/images/vegetables3.jpeg";

const ImagesCarousel = () => {
  return (
    <div id="carouselIndicators" className="carousel slide carousel-fade overflow-hidden" data-bs-ride="carousel" style={{height: "200px"}} >
      <div className="carousel-indicators">
        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="0" className="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div className="carousel-inner">
        <div className="carousel-item active">
          <img src={img1} className="d-block w-100" alt="verduras" />
        </div>
        <div className="carousel-item">
          <img src={img2} className="d-block w-100" alt="verduras" />
        </div>
        <div className="carousel-item">
          <img src={img3} className="d-block w-100" alt="verduras" />
        </div>
      </div>
      <button className="carousel-control-prev" type="button" data-bs-target="#carouselIndicators" data-bs-slide="prev">
        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Anterior</span>
      </button>
      <button className="carousel-control-next" type="button" data-bs-target="#carouselIndicators" data-bs-slide="next">
        <span className="carousel-control-next-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Siguiente</span>
      </button>
    </div>
  );
}

export default ImagesCarousel;