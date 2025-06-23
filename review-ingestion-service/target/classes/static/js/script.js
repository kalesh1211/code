
document.addEventListener('DOMContentLoaded', function () {
  const integrationSelect = document.getElementById('integrationSelect');
  const tableBody = document.querySelector('tbody');
  const saveBtn = document.getElementById('saveBtn');
  const searchInput = document.getElementById('searchInput');

  const apiBase = '/api';

  fetch(`${apiBase}/integrations`)
    .then(res => res.json())
    .then(data => {
      integrationSelect.innerHTML = data.map(i => `<option value="\${i}">\${i}</option>`).join('');
      loadMappings(integrationSelect.value);
    });

  // Change integration
  integrationSelect.addEventListener('change', () => {
    loadMappings(integrationSelect.value);
  });

  function loadMappings(integration) {
    fetch(`${apiBase}/review-mappings?integration=\${integration}`)
      .then(res => res.json())
      .then(data => {
        tableBody.innerHTML = '';
        Object.entries(data).forEach(([key, val]) => {
          tableBody.innerHTML += `
            <tr>
              <td>\${key}</td>
              <td><input class="form-control" value="\${typeof val === 'number' ? 'number' : (typeof val === 'object' ? 'object' : 'string')}" readonly></td>
              <td><input class="form-control" value="\${val}"></td>
            </tr>
          `;
        });
      });
  }

  saveBtn.addEventListener('click', () => {
    const rows = document.querySelectorAll('tbody tr');
    const payload = {};
    rows.forEach(row => {
      const key = row.children[0].innerText;
      const val = row.children[2].querySelector('input, select').value;
      payload[key] = val;
    });

    fetch(`${apiBase}/review-mappings`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        integration: integrationSelect.value,
        mappings: payload
      })
    })
    .then(res => {
      if (res.ok) alert('Mappings saved successfully!');
      else alert('Failed to save mappings.');
    });
  });

  searchInput.addEventListener('input', function () {
    const query = this.value.toLowerCase();
    const rows = document.querySelectorAll('tbody tr');
    rows.forEach(row => {
      const cells = Array.from(row.querySelectorAll('td')).map(td => td.textContent.toLowerCase());
      row.style.display = cells.some(text => text.includes(query)) ? '' : 'none';
    });
  });
});
