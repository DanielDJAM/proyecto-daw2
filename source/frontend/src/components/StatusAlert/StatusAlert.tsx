interface AppState {
  statusClass: string;
  statusDescription: string;
}

const StatusAlert = ({ statusClass, statusDescription }: AppState) => {
  return (
    <div className={`alert ${statusClass}`} role="alert">
      {statusClass === "alert-success" ? (
        <i className="bi bi-check-circle-fill"></i>
      ) : <i className="bi bi-exclamation-triangle-fill"></i>} 
      &nbsp;{statusDescription}
    </div>
  );
}

export default StatusAlert;